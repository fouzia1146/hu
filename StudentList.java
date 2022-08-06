import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] input) {

//    Check arguments
		if(input[0].equals("a"))
		{
			System.out.println("Loading data ...");
			String substring=input[0].substring(1);
			if(substring.length()==0)
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
					String line = bufferedReader.readLine();
					String students[] = line.split(", ");
					for (String student : students) {
						System.out.println(student);
					}
				} catch (Exception e) {

				}
				System.out.println("Data Loaded.");
			}
			else
				System.out.println("Invalid input");
		}
		else if(input[0].equals("r"))
		{
			System.out.println("Loading data ...");
			String substring=input[0].substring(1);
			if(substring.length()==0)
			{
				try
				{
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
					String line = bufferedReader.readLine();
					String students[] = line.split(", ");
					Random random = new Random();
					int index = random.nextInt(students.length);
					System.out.println(students[index]);
				} catch (Exception e)
				{

				}
			}
			else
				System.out.println("Invalid input");
			System.out.println("Data Loaded.");
		}
		else if(input[0].contains("+"))
		{
			System.out.println("Loading data ...");
			try
			{
				String line = Files.readAllLines(Paths.get("students.txt")).get(0);
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));
				String input_txt = input[0].substring(1);
				FileWriter fileWriter = new FileWriter("students.txt", false);
				PrintWriter printWriter = new PrintWriter(fileWriter, false);
				printWriter.flush();
				printWriter.close();
				fileWriter.close();
				Date date = new Date();
				String dateFormater = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateFormater);
				String fd= dateFormat.format(date);
				bufferedWriter.write(line+", "+ input_txt +"\nList last updated on "+fd);
				bufferedWriter.close();
			} catch (Exception e){}

			System.out.println("Data Loaded.");
		}
		else if(input[0].contains("?"))
		{
			System.out.println("Loading data ...");
			try
			{
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String line = bufferedReader.readLine();
				String students[] = line.split(", ");
				boolean done = false;
				String input_word = input[0].substring(1);
				for(int index = 0; index < students.length && !done; index++)
				{
					if(students[index].equals(input_word))
					{
						System.out.println("We found it!");
						done=true;
					}
				}
				if(done==false)
					System.out.println("Not found!");
			} catch (Exception e)
			{

			}
			System.out.println("Data Loaded.");
		}
		else if(input[0].contains("c"))
		{
			System.out.println("Loading data ...");
			String b=input[0].substring(1);
			if(b.length()==0) {
				try {
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
					String line = bufferedReader.readLine();
					char chars[] = line.toCharArray();
					int count = 0;
					for (char Char : chars) {
						if (Char == ' ') {
							count++;
						}
					}
					System.out.println(count + 1 + " word(s) found " + chars.length);
				} catch (Exception e) {

				}
			}
			else
				System.out.println("invalid input");
			System.out.println("Data Loaded.");
		}
		}
		else
		{
			System.out.println("invalid input");
		}
	}
}