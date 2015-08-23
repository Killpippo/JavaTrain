package ob1test;

import java.util.HashMap;
import java.util.Map;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;


interface IIdentity<T>
{
    public T getID();
    public void setID(T _id);
}

interface IMappable
{
    public Map<java.lang.String,Object> getMap();
}

abstract class Persistent implements IIdentity,IMappable
{    
}
        
interface IRepository
{
    public void Create( Persistent _obj );
    public void Update( Persistent _obj );
    public void Delete( Persistent _obj );
}

class FrameMap implements IMappable
{
    private String _data;
    
    public FrameMap( String _data )
    {
        this._data = _data;
    }
            
    @Override
    public Map<String, Object> getMap() {
        Map<java.lang.String,Object> oMap = new HashMap<>();
        
        oMap.put("data", _data);
        
        return oMap;
    }    
}

class BoardObj extends Persistent
{
    private java.lang.String _id;
    private FrameMap _frame;
            
    public BoardObj( String _id, FrameMap _frame ) {
        this.setID(_id);
        this._frame = _frame;        
    }
    
    @Override
    public java.lang.String getID() {
        return _id;
    }
    
    @Override
    public void setID(Object _id) {
        this._id = _id.toString();
    }
    
    @Override
    public Map<java.lang.String,Object> getMap() {
        Map<java.lang.String,Object> oMap = new HashMap<>();
        
        oMap.put("_id", getID());
        oMap.put("frame",_frame.getMap());
        
        return oMap;        
    }
}

public class OB1Test {

    public static void main(String[] args) {
        
        //Gson oGson = new Gson();        
        //System.out.println( oGson.toJson(boardObj.getMap()) );
        
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
                
        DB mongoDatabase = mongoClient.getDB( "pippoDB" );

        DBCollection mongoCollection = mongoDatabase.getCollection("pippoSchema");

//        for ( int i=0; i<10; i++ )
//        {
//            BoardObj boardObj = new BoardObj( Integer.toString(i), new FrameMap( "framedata") );
//            
//            BasicDBObject obj = new BasicDBObject(boardObj.getMap());
//            
//            mongoCollection.insert( obj );
//        }
        
        DBCursor cursor = mongoCollection.find();
        
        try {
            while(cursor.hasNext()) {
                System.out.println(cursor.next());
            }
         } finally {
            cursor.close();
         }
        
        mongoClient.close();
        
    }
    
}
