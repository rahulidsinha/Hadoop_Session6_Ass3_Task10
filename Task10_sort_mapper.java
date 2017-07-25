import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Task10_sort_mapper extends Mapper<LongWritable,Text, Text,Tv_sales_state_comparable> {
	
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		String temp = value.toString();
		
		String splits[] = temp.split("\t");
		
		// Company name as KEY, Sales and State as VALUE
		context.write(new Text(splits[0]), new Tv_sales_state_comparable(Integer.parseInt(splits[2]), splits[1]) );
	}
}
