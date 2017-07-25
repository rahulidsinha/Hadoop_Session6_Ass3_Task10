import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.WritableComparable;

public class Tv_sales_state_comparable implements WritableComparable <Tv_sales_state_comparable> {

	public String state;
	public int sale;
	
	public Tv_sales_state_comparable()
	{
		
	}
	
	public Tv_sales_state_comparable (int sale,String state)
	{
		 set(sale,state);
	}
	
	public void set(int sale,String state)
	{
		this.state = state;
		this.sale = sale;
	}
	public int get_sale()
	{
		return this.sale;
	}
	public String get_state()
	{
		return this.state;
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		 sale = in.readInt();
		 state = in.readUTF();
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(sale);
		out.writeUTF(state);
		
	}
	@Override
	public int compareTo(Tv_sales_state_comparable o) {
		return (-1)*(sale-o.get_sale());
	}
	
	public String toString()
	{
		return (state + "\t" + sale);
	}
	public boolean equals(Object o)
	{
		if (o instanceof Tv_sales_state_comparable)
		{
			Tv_sales_state_comparable obj = (Tv_sales_state_comparable) o;
			return state.equalsIgnoreCase(obj.get_state()) && (sale == obj.get_sale());
		}
		return false;
	}
	public int hashcode()
	{
		return this.state.hashCode();
	}
	
	

}
