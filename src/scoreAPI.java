import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class scoreAPI 
{
	public static void main(String[] args) 
	{
		long start = System.currentTimeMillis();
		LocalDate localDate = java.time.LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String date = localDate.format(formatter);
		String dateS = "2019-02-05";
		System.out.println(dateS);
		try 
		{
			String url = "https://www.thescore.com/nba/events/date/"+dateS;
			//Document doc = Jsoup.connect("https://www.thescore.com/nfl/events").userAgent("Chrome/68.0.3440.106").get();
			Document doc = Jsoup.connect(url).get();
			Elements elem = doc.select("div#__next");
			ArrayList<String> match = new ArrayList<>();
			ArrayList<String> times = new ArrayList<>();
			ArrayList<String> scoresW = new ArrayList<>();
			boolean started = true;
			for(Element element:elem.select("div.EventCard__teamName--JweK5"))
			{
				match.add(element.select("div.EventCard__teamName--JweK5").text());
			}//end for loop
			for(Element element:elem.select("div.EventCard__clockColumn--3lEPz"))
			{
				times.add(element.select("div.EventCard__clockColumn--3lEPz").text());
			}//end for loop
			if(elem.select("div.EventCard__score--2C1-p").text() != null)
			{
				for(Element element:elem.select("div.EventCard__score--2C1-p"))
				{
					scoresW.add(element.select("div.EventCard__score--2C1-p").text());
				}//end for loop
			}//end if
			if (elem.select("div.EventCard__pregameScoreText--ow7eN").text() != null)
			{
				for(Element element:elem.select("div.EventCard__pregameScoreText--ow7eN"))
				{
					started = false;
					scoresW.add(element.select("div.EventCard__pregameScoreText--ow7eN").text());
				}//end for loop
			}//end if

			//Loading matches into objects
			ArrayList<Match> matches = new ArrayList<Match>();
			int k=0;
			if(started)
			{
				for (int j = 0; j < match.size(); j+=2) 
				{
					matches.add(new Match(match.get(j), match.get(j+1),scoresW.get(j),scoresW.get(j+1),times.get(k)));
					k++;
				}//end for loop
			}//end if
			else
			{
				for (int j = 0; j < match.size(); j+=2) 
				{
					matches.add(new Match(match.get(j), match.get(j+1),times.get(k)));
					k++;
				}//end for loop
			}//end else
			//Printing out scoreboard
			if(started)
			{
				for (int i = 0; i < matches.size(); i++) 
				{
					System.out.println(matches.get(i).toString());
				}//end for loop
			}//end if
			else
			{
				for (int i = 0; i < matches.size(); i++) 
				{
					System.out.println(matches.get(i).toString2());
				}//end for loop
			}//end else
		}//end try
		catch (IOException e) 
		{
			e.printStackTrace();
		}//end catch

		long end = System.currentTimeMillis();
		NumberFormat formatter1 = new DecimalFormat("#0.00000");
		System.out.print("Runtime: " + formatter1.format((end - start) / 1000d) + " seconds");

	}//end main
}//end class
