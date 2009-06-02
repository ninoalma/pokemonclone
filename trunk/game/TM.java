package game;

import java.util.*;

public class TM extends LearnItem {

	private int number;
	private Move move;
	
	public int number(){return number;}
	public Move move(){return move;}
	
	private TM(XmlElement e)
	{
		number = e.icontentOf("number");
		move = Move.named(e.contentOf("name"));
	}
	
	private static ArrayList<TM> tms = new ArrayList<TM>();
	static { 
		try{
			XmlElement root = XmlElement.documentRootFrom(Game.jarStream("./species/tmsAndHms.xml"));
			for(XmlElement e : root.children("tm"))
			{
				TM t = new TM(e);
				tms.add(t);
				//System.out.print(t.number+" ");
			}
				
			System.out.println("\n"+tms.size()+" TMs!");
		}catch(Exception e){e.printStackTrace();}
	}
	
	public static java.util.List<TM> allTMs(){
		return tms;
	}
	public static TM numbered(int no){
		for(TM t:tms)
			if(t.number==no)
				return t;
		return null;
	}

}