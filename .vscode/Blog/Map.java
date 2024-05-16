import java.io.IOException;
@SuppressWarnings("unused")
public class Map {

    private class Users
    {
        private String UserName;
        private String Value;
        private Blog blog;

        public Users(String k, String v) throws IOException
        {
            UserName = k;
            Value = v;
            blog = new Blog(UserName);
        }

        public String getValue()
        {
            return Value;
        }

        public String getKey()
        {
            return UserName;
        }
        
    }

    private Users[] vUsers;
    private final int InitialCapacity = 1;
    private int vSize;

    public Map()
    {
        makeEmpty();
    }
    
    public void makeEmpty()
    {
        vSize = 0;
        vUsers = new Users[InitialCapacity];
    }

    
    public boolean isEmpty()
    {
        return vSize<=0;
    }

    
    public String getPassword(String K)
    {
        return vUsers[linearSearch(K)].getValue();

    }
    
    public void addUser(String k, String v)throws IOException
    {
        if(k.equals(null) || v.equals(null))
        {
            throw new IllegalArgumentException();
        }

        int pos = linearSearch(k);

        if(pos>=0)
        {
            throw new IllegalArgumentException("User Name In Use");
        }

        if(vSize<=vUsers.length)
        {
            Users[] newent = new Users[vUsers.length * 2];
            System.arraycopy(vUsers, 0, newent, 0, vSize);
            vUsers = newent;
        }

        vUsers[vSize++]= new Users(k,v);

    }

    
    public String remove(String K)
    {  
        int pos = linearSearch(K);
        if(pos>=0)
        {
            String returned = vUsers[pos].getValue();
            vUsers[pos]=vUsers[vSize];
            vUsers[vSize]=null;
            return returned;
        }   
        return null;
    }

    
    public String[] UserNames()
    {
        String[] returned = new String[vSize];
        for(int i = 0; i<vSize;i++)
        {
            returned[i]=vUsers[i].getKey();
        }
        return returned;
    }
    private int linearSearch(String K)
    {
        for(int i = 0; i<vSize;i++)
        {
            if(vUsers[i].getKey().equals(K))
            {
                return i;
            }
        }
        return-1;
    }
   
}
