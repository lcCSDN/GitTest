package com.yc.paixu;

import java.util.Random;

public class maopao {

	public static void main(String[] args) {
		int[] s = new int[10];
		
		Random rd = new Random();
		
		for(int i=0;i<s.length;i++){
			s[i] = rd.nextInt(100);
		}
		
		System.out.println("排序前的数组");
		for(int i:s){
			
			System.out.print(i+"	");
			
		}
		System.out.println();
		//mp(s);
		
		//xuanzhe(s);
		
		//cr(s);
		
//		buildMaxHeapify(s);
//		heapSort(s);
//		print(s);
		
		shellSortSmallToBig(s);
		
		System.out.println("冒泡排序后的数组");
		for(int i:s){
			System.out.print(i+"	");
		}
		
	}
	
	//选择
	private static void xuanzhe(int[] s) {
		for(int i=0;i<s.length-1;i++){//从第一个开始与后面的比较
			for(int j=i+1;j<s.length;j++){
				if(s[i]>s[j]){
					s[i] = s[i]+s[j];
					s[j] = s[i] - s[j];
					s[i] = s[i] - s[j];
				}
			}
		}
	}
	//冒泡
	private static void mp(int[] s) {
		
		for(int i=0;i<s.length-1;i++){
			for(int j=0;j<s.length-1-i;j++){
				if(s[j]>s[j+1]){
					int temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
				}
			}
		}
	}
	
	//插入（从第一个开始比较 ，当遇到比其小（大）的数字是，进行插入  与选择排序的区别是比较的比较的数组是有序的）
	
	private static void cr(int[] s){
		int j;
		for(int i=1;i<s.length;i++){
			
			int temp = s[i];
			for( j = i; j > 0 && temp<s[j-1]; j--){
				
				s[j] = s[j-1];//向后移位
				
			}
			s[j] = temp;
		}
	}
	
	//堆排序
	
	private static void buildMaxHeapify(int[] data){
		//没有子节点的才需要创建最大堆，从最后一个的父节点开始
		int startIndex=getParentIndex(data.length-1);
		//从尾端开始创建最大堆，每次都是正确的堆
		for(int i=startIndex;i>=0;i--){
		maxHeapify(data,data.length,i);
		}
		}
		 
		/**
		*创建最大堆
		*
		*@paramdata
		*@paramheapSize需要创建最大堆的大小，一般在sort的时候用到，因为最多值放在末尾，末尾就不再归入最大堆了
		*@paramindex当前需要创建最大堆的位置
		*/
		private static void maxHeapify(int[] data,int heapSize,int index){
		//当前点与左右子节点比较
		int left=getChildLeftIndex(index);
		int right=getChildRightIndex(index);
		 
		int largest=index;
		if(left<heapSize&&data[index]<data[left]){
		largest=left;
		}
		if(right<heapSize&&data[largest]<data[right]){
		largest=right;
		}
		//得到最大值后可能需要交换，如果交换了，其子节点可能就不是最大堆了，需要重新调整
		if(largest!=index){
		int temp=data[index];
		data[index]=data[largest];
		data[largest]=temp;
		maxHeapify(data,heapSize,largest);
		}
		}
		 
		/**
		*排序，最大值放在末尾，data虽然是最大堆，在排序后就成了递增的
		*
		*@paramdata
		*/
		private static void heapSort(int[] data){
		//末尾与头交换，交换后调整最大堆
		for(int i=data.length-1;i>0;i--){
		int temp=data[0];
		data[0]=data[i];
		data[i]=temp;
		maxHeapify(data,i,0);
		}
		}
		 
		/**
		*父节点位置
		*
		*@paramcurrent
		*@return
		*/
		private static int getParentIndex(int current){
		return(current-1)>>1;
		}
		 
		/**
		*左子节点position注意括号，加法优先级更高
		*
		*@paramcurrent
		*@return
		*/
		private static int getChildLeftIndex(int current){
		return(current<<1)+1;
		}
		 
		/**
		*右子节点position
		*
		*@paramcurrent
		*@return
		*/
		private static int getChildRightIndex(int current){
		return(current<<1)+2;
		}
		 
		private static void print(int[] data){
		int pre=-2;
		for(int i=0;i<data.length;i++){
		if(pre<(int)getLog(i+1)){
		pre=(int)getLog(i+1);
		System.out.println();
		}
		System.out.print(data[i]+"|");
		}
		}
		 
		/**
		*以2为底的对数
		*
		*@paramparam
		*@return
		*/
		private static double getLog(double param){
		return Math.log(param)/Math.log(2);
		}
		
	
		public static void shellSortSmallToBig(int[] data) {
	        int j = 0;
	        int temp = 0;
	        for (int increment = data.length / 2; increment > 0; increment /= 2) {
	        	//控制分为increment个数组，每个数组单独进行比较
	            for (int i = increment; i < data.length; i++) {
	            	
	                // System.out.println("i:" + i);
	                temp = data[i];
	                for (j = i - increment; j >= 0; j -= increment) {
	                    // System.out.println("j:" + j);
	                    // System.out.println("temp:" + temp);
	                    // System.out.println("data[" + j + "]:" + data[j]);
	                    if (temp < data[j]) {
	                        data[j + increment] = data[j];
	                    } else {
	                        break;
	                    }
	                }
	                data[j + increment] = temp;
	            }
	        }
	    }
	
}
