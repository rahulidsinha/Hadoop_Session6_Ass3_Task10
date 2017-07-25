import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Task10_sort_reducer extends Reducer<Text, Tv_sales_state_comparable, Text,Tv_sales_state_comparable>{

	public void reduce(Text key, Iterable<Tv_sales_state_comparable> values, Context context) throws IOException, InterruptedException
	{
		ArrayList<Tv_sales_state_comparable> records = new ArrayList<Tv_sales_state_comparable>();
		
		for(Tv_sales_state_comparable value:values)
		{
			records.add(new Tv_sales_state_comparable(value.get_sale(),value.get_state()));
		}
		
		Collections.sort(records);
		
		// We have to take only the first three record, so counter will traverse three times
		int count = 1;
		
		for (Tv_sales_state_comparable record : records )
		{
			if(count > 3)
				break;
			
			context.write(key, record);
			count++;
		}
		
	}
}
