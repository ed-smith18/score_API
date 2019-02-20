
public class Match 
{
	private String team1;
	private String team2;
	private String score1;
	private String score2;
	private String time;


	public Match(String team1,String team2,String time) 
	{
		this.team1 = team1;
		this.team2 = team2;
		this.time = time;
	}//end before game Match constructor

	public Match(String team1,String team2,String score1,String score2,String time) 
	{
		this.team1 = team1;
		this.team2 = team2;
		this.score1 = score1;
		this.score2 = score2;
		this.time = time;
	}//end during/after game Match constructor


	public String getTeam1() 
	{
		return team1;
	}

	public void setTeam1(String team1) 
	{
		this.team1 = team1;
	}

	public String getTeam2()
	{
		return team2;
	}

	public void setTeam2(String team2) 
	{
		this.team2 = team2;
	}

	public String getScore1() 
	{
		return score1;
	}

	public void setScore1(String score1)
	{
		this.score1 = score1;
	}

	public String getScore2() 
	{
		return score2;
	}

	public void setScore2(String score2)
	{
		this.score2 = score2;
	}

	public String getTime() 
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}

	public String toString()
	{
		return team1 +"-"+score1+"    "+team2+"-"+score2+": "+time;
	}
	public String toString2()
	{
		return team1 +"    "+team2+": "+time;
	}
}//end Match class
