/**
 * 
 */
package com.zzxt.problem.paixu;

/**
 * @Description:
 * 排序算法大体可分为两种：
 * 	  1>比较排序:  时间复杂度O(nlogn) ~ O(n^2)
 * 		冒泡排序，选择排序，插入排序，归并排序，堆排序，快速排序
 * 	  2>非比较排序: 时间复杂度可以达到O(n)
 *      计数排序，基数排序，桶排序
 * 
 * @Company  郑州兴唐IT教育
 * @author 王滔
 * @email 675475017@qq.com
 * @date：2017年9月13日下午9:39:26
 */
public class Paixu {

	/**
	 * 冒泡排序:冒泡排序是一种极其简单的排序算法，它重复地走访过要排序的元素，
	 * 	依次比较相邻两个元素，如果他们的顺序错误就把他们调换过来，直到没有元素再需要交换，排序完成。
	 *  这个算法的名字由来是因为越小(或越大)的元素会经由交换慢慢“浮”到数列的顶端。
	 *  
	 *  排序步骤：
	 *  	1> 比较相邻的元素，如果前一个比后一个大，就把它们两个调换位置。
	 *		2> 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
	 *		3> 针对所有的元素重复以上的步骤，除了最后一个。
	 *		4> 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
	 * 
	 */
	public void bubbleSort(int[] array) {
		int l = array.length;
		for (int j = 0; j < l; j++) {
	        for (int i = 0; i < l - j; i++) {
	        	// 依次比较相邻的两个元素,使较大的那个向后移
	            if (array[i] > array[i + 1]){
	            	switchData(array, i, i + 1);
	            }
	        }
	    }
	}
	
	
	/**
	 * 鸡尾酒排序，也叫定向冒泡排序，是冒泡排序的一种改进。此算法与冒泡排序的不同处在于从低到高然后从高到低，
	 * 而冒泡排序则仅从低到高去比较序列里的每个元素。他可以得到比冒泡排序稍微好一点的效能。
	 * @param array
	 */
	public void bubbleSortUpdate(int[] array) {
		// 初始化边界 
		int left = 0;                            
	    int right = array.length;
	    
	    while (left < right){
	    	// 前半轮,将最大元素放到后面
	        for (int i = left; i < right; i++){
	            if (array[i] > array[i + 1]){
	            	switchData(array, i, i + 1);
	            }
	        }
	        right--;
	        
	     // 后半轮,将最小元素放到前面
	        for (int i = right; i > left; i--){
	            if (array[i - 1] > array[i]){
	            	switchData(array, i - 1, i);
	            }
	        }
	        left++;
	    }
	}
	
	/**
	 * 选择排序也是一种简单直观的排序算法。它的工作原理很容易理解：初始时在序列中找到最小（大）元素，
	 * 放到序列的起始位置作为已排序序列；然后，再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾。
	 * 以此类推，直到所有元素均排序完毕。
	 * @param array
	 */
	public void selectionSort(int[] array){
		int l = array.length;
		for (int i = 0; i < l; i++){
	        int min = i;
	        for (int j = i + 1; j < l; j++){
	            if (array[j] < array[min]){
	                min = j;
	            }
	        }
	     // 放到已排序序列的末尾，该操作很有可能把稳定性打乱，所以选择排序是不稳定的排序算法
	        if (min != i){
	        	switchData(array, min, i);    
	        }
	    }
	}
	
	/**
	 * 插入排序：插入排序是一种简单直观的排序算法，插入排序在实现上，
	 * 		通常采用in-place排序（即只需用到O(1)的额外空间的排序），
	 * 		因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
	 * 步骤：
	 *	   1> 从第一个元素开始，该元素可以认为已经被排序
	 *	   2> 取出下一个元素，在已经排序的元素序列中从后向前扫描
	 *	   3> 如果该元素（已排序）大于新元素，将该元素移到下一位置
	 *	   4> 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
	 *	   5> 将新元素插入到该位置后
	 *	   6> 重复步骤2~5
	 *
     * 应用：	插入排序不适合对于数据量比较大的排序应用。但是，如果需要排序的数据量很小，
     * 		比如量级小于千，那么插入排序还是一个不错的选择。 插入排序在工业级库中也有着广泛的应用，
     * 		在STL的sort算法和stdlib的qsort算法中，都将插入排序作为快速排序的补充，
     * 		用于少量元素的排序（通常为8个或以下）
	 * @param array
	 */
	public void insertionSort(int[] array) {
		int l = array.length;
		for (int i = 1; i < l; i++){
			//先获取一个数据
	        int get = array[i];                
	        int j = i - 1;
	        //将获取的数据右向左进行比较
	        while (j >= 0 && array[j] > get){
	        	// 如果该手牌比抓到的牌大，就将其右移
	        	array[j + 1] = array[j];            
	            j--;
	        }
	        array[j + 1] = get; // 直到该手牌比抓到的牌小(或二者相等)，将抓到的牌插入到该手牌右边(相等元素的相对次序未变，所以插入排序是稳定的)
	    }
	}
	
	/**
	 * 
	 * @param array
	 */
	public void insertionSortDichotomy(int[] array){
		int l = array.length;
		for (int i = 1; i < l; i++){
			// 右手抓到一张扑克牌
	        int get = array[i];                    
	        // 拿在左手上的牌总是排序好的，所以可以用二分法
	        int left = 0;                   
	        // 手牌左右边界进行初始化
	        int right = i - 1;                
	        while (left <= right){
	            int mid = (left + right) / 2;
	            if (array[mid] > get)
	                right = mid - 1;
	            else
	                left = mid + 1;
	        }
	     // 将欲插入新牌位置右边的牌整体向右移动一个单位
	        for (int j = i - 1; j >= left; j--){
	        	array[j + 1] = array[j];
	        }
	     // 将抓到的牌插入手牌
	        array[left] = get;                    
	    }
	}
	
	/**
	 * 希尔排序: 也叫递减增量排序，是插入排序的一种更高效的改进版本。希尔排序是不稳定的排序算法。
	 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
	 *	   1> 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
	 *	   2> 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位
	 *
	 *		希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。这样可以让一个元素可以一次性地朝最终位置前进一大步。
	 *  然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，但是到了这步，需排序的数据几乎是已排好的了（此时插入排序较快）。
　　	 *		假设有一个很小的数据在一个已按升序排好序的数组的末端。如果用复杂度为O(n^2)的排序（冒泡排序或直接插入排序），
	 *	可能会进行n次的比较和交换才能将该数据移至正确位置。而希尔排序会用较大的步长移动数据，所以小数据只需进行少数比较和交换即可到正确位置。
	 * @param array
	 */
	public void shellSort(int[] array) {
		int h = 0;
		int l = array.length;
	    while (h <= l){
	        h = 3 * h + 1;
	    }
	    while (h >= 1){
	        for (int i = h; i < l; i++){
	            int j = i - h;
	            int get = array[i];
	            while (j >= 0 && array[j] > get){
	            	array[j + h] = array[j];
	                j = j - h;
	            }
	            array[j + h] = get;
	        }
	        h = (h - 1) / 3;        
	    }
	}
	
	/**
	 * 归并排序是创建在归并操作上的一种有效的排序算法，效率为O(nlogn)，1945年由冯·诺伊曼首次提出。
	 * 归并排序的实现分为递归实现与非递归(迭代)实现。递归实现的归并排序是算法设计中分治策略的典型应用，我们将一个大问题分割成小问题分别解决，
	 * 	然后用所有小问题的答案来解决整个大问题。非递归(迭代)实现的归并排序首先进行是两两归并，然后四四归并，然后是八八归并，一直下去直到归并了整个数组。
	 * 归并排序算法主要依赖归并(Merge)操作。归并操作指的是将两个已经排序的序列合并成一个序列的操作，归并操作步骤如下：
	 * 
	 * 
	 *	申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
	 * 	设定两个指针，最初位置分别为两个已经排序序列的起始位置
	 *	比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
	 * 	重复步骤3直到某一指针到达序列尾
	 *	将另一序列剩下的所有元素直接复制到合并序列尾
	 */
	public void mergeSort(int[] array) {
		
	}
	
	/**
	 * 交换数据
	 * @param array
	 * @param i
	 * @param j
	 */
	private void switchData(int array[], int i, int j){
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}
	
	public static void main(String[] args) {
		 int array[] = { 16, 45, 53, 61, 28, 47, 12, 24 };
		 Paixu as = new Paixu();
		 as.insertionSort(array);
		 for(int data : array) {
			 System.out.print(" | " + data);
		 }
	}
}
