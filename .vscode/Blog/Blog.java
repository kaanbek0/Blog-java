/*
 * boşluk yaratma metodu
 * blogları alabilme
 *  
 * 
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
@SuppressWarnings("unused")
public class Blog {
    private class Post
    {
        private String[] header;
        private String body;

        public void Post(String h, String b)
        {   
            int times = (b.length()/100)-1;
            String[] newBody = new String[times];
            if(b.length()>100)
            {
                for(int i=0;i<=times;i++)
                {

                    newBody[i]=b.substring(i*100,((i+1)*100)-1)+"\n";

                }

            }
            header = newBody;
            body = b;
        }

            
    }

    private Post[] posts = new Post[100];
    private int numPost=0;

    public Blog(String name) throws IOException
    {
        String fileName = name+".txt";
        numPost=0;
        File file = new File(fileName);
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileReader freader = new FileReader(fileName);
        Scanner in = new Scanner(freader);
        int times = in.nextInt();

        for(int i=0;i<=times;i++)
        {
            String[] poster = in.nextLine().split("*");
            posts[numPost++].Post(poster[0],poster[1]);
        }

        freader.close();
        in.close();
    }
    public void newPost(String h, String b)
    {
        //add resize algorithm
        posts[numPost++].Post(h,b);

    }
    @Override
    private String toString()
    {
        
    }

    public String outPosts()
    {
        return toString();
    }


}
