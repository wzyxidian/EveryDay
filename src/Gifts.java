import java.util.HashMap;
import java.util.Map;


/**
 * @author zhiyong wang
 * 找出一个数值出现的次数占总数的一半多
 */
public class Gifts {

	public int gifts(int[] gift, int n){
		Map map = new HashMap();
		for(int i=0;i<n;i++){
			if((int)map.get(gift[i]) > n / 2){
				return gift[i];
			}
			if(map.containsKey(gift[i])){
				map.put(gift[i], map.get(gift[i] + 1));
			}else{
				map.put(gift[i], 1);
			}				
		}
		return -1;
	}
}
