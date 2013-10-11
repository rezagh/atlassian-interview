package findarray;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//objective: find a sub array inside another array
public class MyFindArray implements FindArray{

	@Test
	public void test(){
		int[] array = {1,6,3,9,2,3};
		int[] subArray = {2,3};
		System.out.println(findArray(array, subArray));
	}
	@Override
	public int findArray(int[] array, int[] subArray) {
		//int notFound = -1;
		for(int i = 0 ; i < array.length ; i++){
			if(subArray[0] == array[i]){
				int res = foundSub(i,array,subArray);
				if( res == -1) continue;
				else return res;
			}
			
		}
		return -1;
	}

	int foundSub(int startIndex, int[] array, int[] subArray){
		for(int j = 0 ; j<subArray.length ; j++){
			if (array[startIndex+j] != subArray[j]) return -1;
		}

		return startIndex;
	}


}
