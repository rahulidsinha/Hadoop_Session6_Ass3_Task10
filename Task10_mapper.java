import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Task10_mapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		String temp = value.toString();
		
		String[] splits = temp.split("\\|");
		
		String outputkey = (splits[0]+"\t"+splits[3]);
		
		context.write(new Text(outputkey), new IntWritable(1));
	}

}
