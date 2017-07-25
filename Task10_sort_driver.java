import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Task10_sort_driver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		// Driver to sort company sales by first 3 states from company total sales
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf, " Sort company sales by first 3 states");
		
		job.setJarByClass(Task10_sort_driver.class);
		job.setMapperClass(Task10_sort_mapper.class);
		job.setReducerClass(Task10_sort_reducer.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Tv_sales_state_comparable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Tv_sales_state_comparable.class);
		
		System.exit(job.waitForCompletion(true) ? 0 : -1);
	}

}
