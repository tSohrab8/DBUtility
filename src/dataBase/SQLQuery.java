package dataBase;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class SQLQuery {

	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter an sql statement");
		String sql = scan.nextLine();
		
		System.out.println("Please enter the username");
		String user = scan.next();
		
		System.out.println("Please enter the password");
		String pw = scan.next();
		
		String first = sql.split(" ")[0];
		
		ArrayList<LinkedHashMap<String,String>> selectList = null;
		
		if (first.equals("select")){
			selectList = DBUtility.select(sql, user, pw);
		}
		
		Iterator<String> iter = selectList.get(0).keySet().iterator();
		
		ArrayList<String> keys = new ArrayList<String>();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html>"
				+ "<body>"
				+ "<table>"
				+ "<tr>");
		
		while (iter.hasNext()){
			String key = iter.next();
			keys.add(key);
			sb.append("<th>" + key + "</th>");
		}
		sb.append("</tr>");
		
		for (int j = 0; j < selectList.size(); j++){
			sb.append("<tr>");
			for (int i = 0; i < keys.size(); i++){
				String val = selectList.get(j).get(keys.get(i));
				sb.append("<td>" + val + "</td>");
			}
			sb.append("</tr>");
		}
		sb.append("</table></body></html>");
		
		try{
			generateHTML(sb);
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		
	}
	
	public static void generateHTML(StringBuilder text) throws FileNotFoundException{
		try(  PrintWriter out = new PrintWriter( "index.html" )  ){
		    out.println( text.toString() );
		}
		
	}
	
}
