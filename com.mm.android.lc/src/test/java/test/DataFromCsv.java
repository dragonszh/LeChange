package test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class DataFromCsv {
	public static Object[][] readFromCsv(String csvPath) throws IOException{
		CsvReader csvRead = new CsvReader(csvPath,',',Charset.forName("UTF-8"));
		//指针判断第一行是否有数据，然后指针下移。
		csvRead.readHeaders();
		System.out.println("--------------读取csv文件-------------------");

		List<Object[]> list = new ArrayList<Object[]>();
		while(csvRead.readRecord()){
			list.add(csvRead.getValues());
			System.out.println("----初始化获取csv数据-----");
			System.out.println(csvRead.getValues());
		}
		
		Object[][] dataTable = new Object [list.size()][];
		for (int i = 0;i < list.size();i++)
		{
			dataTable[i] = list.get(i);
		}		
		csvRead.close();
		return dataTable;
	}
	
	public void writeToCsv(String csvPath) throws IOException{
		CsvWriter csvWriter = new CsvWriter(csvPath,',',Charset.forName("UTF-8"));
		List<String[]> list = new ArrayList<String[]>();
		String[] contents = {"Lily","五一","90","女"};                    
		csvWriter.writeRecord(contents);
		csvWriter.close();
	}
}
