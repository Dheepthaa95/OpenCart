package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Logindata")
	
	public String[][] getdata() throws IOException
	{
		String path=".\\TestData\\RawData.xlsx";
		
		Excelutils xlutil=new Excelutils(path);
		int totalrows= xlutil.getrowcount("Sheet1");
		int totalcols= xlutil.getcellcount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) 
		{
			for(int j=0;j<totalcols;j++) 
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i,j);
			}
		}
		
		return logindata;
		
	}

}
