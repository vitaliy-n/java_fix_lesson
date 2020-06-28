import com.cheba00.CostCalculator;
import com.cheba00.Table;
public class Program{
	public static void main(String[] args){
		Table table = new Table(3, 4);
		Table big_table = new Table(10, 100);
		
		CostCalculator costCalculator  = new CostCalculator(30, 20);
		
		double cost_1 = costCalculator.calcCost(table, 1);
		double cost_2 = costCalculator.calcCost(big_table, 1);
		
		System.out.println(cost_1);
		System.out.println(cost_2);
		
	}
}