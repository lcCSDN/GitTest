package com.yc.paixu;

import java.util.Random;

public class maopao {

	public static void main(String[] args) {
		int[] s = new int[10];
		
		Random rd = new Random();
		
		for(int i=0;i<s.length;i++){
			s[i] = rd.nextInt(100);
		}
		
		System.out.println("����ǰ������");
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
		
		System.out.println("ð������������");
		for(int i:s){
			System.out.print(i+"	");
		}
		
	}
	
	//ѡ��
	private static void xuanzhe(int[] s) {
		for(int i=0;i<s.length-1;i++){//�ӵ�һ����ʼ�����ıȽ�
			for(int j=i+1;j<s.length;j++){
				if(s[i]>s[j]){
					s[i] = s[i]+s[j];
					s[j] = s[i] - s[j];
					s[i] = s[i] - s[j];
				}
			}
		}
	}
	//ð��
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
	
	//���루�ӵ�һ����ʼ�Ƚ� ������������С���󣩵������ǣ����в���  ��ѡ������������ǱȽϵıȽϵ�����������ģ�
	
	private static void cr(int[] s){
		int j;
		for(int i=1;i<s.length;i++){
			
			int temp = s[i];
			for( j = i; j > 0 && temp<s[j-1]; j--){
				
				s[j] = s[j-1];//�����λ
				
			}
			s[j] = temp;
		}
	}
	
	//������
	
	private static void buildMaxHeapify(int[] data){
		//û���ӽڵ�Ĳ���Ҫ�������ѣ������һ���ĸ��ڵ㿪ʼ
		int startIndex=getParentIndex(data.length-1);
		//��β�˿�ʼ�������ѣ�ÿ�ζ�����ȷ�Ķ�
		for(int i=startIndex;i>=0;i--){
		maxHeapify(data,data.length,i);
		}
		}
		 
		/**
		*��������
		*
		*@paramdata
		*@paramheapSize��Ҫ�������ѵĴ�С��һ����sort��ʱ���õ�����Ϊ���ֵ����ĩβ��ĩβ�Ͳ��ٹ���������
		*@paramindex��ǰ��Ҫ�������ѵ�λ��
		*/
		private static void maxHeapify(int[] data,int heapSize,int index){
		//��ǰ���������ӽڵ�Ƚ�
		int left=getChildLeftIndex(index);
		int right=getChildRightIndex(index);
		 
		int largest=index;
		if(left<heapSize&&data[index]<data[left]){
		largest=left;
		}
		if(right<heapSize&&data[largest]<data[right]){
		largest=right;
		}
		//�õ����ֵ�������Ҫ��������������ˣ����ӽڵ���ܾͲ��������ˣ���Ҫ���µ���
		if(largest!=index){
		int temp=data[index];
		data[index]=data[largest];
		data[largest]=temp;
		maxHeapify(data,heapSize,largest);
		}
		}
		 
		/**
		*�������ֵ����ĩβ��data��Ȼ�����ѣ��������ͳ��˵�����
		*
		*@paramdata
		*/
		private static void heapSort(int[] data){
		//ĩβ��ͷ�������������������
		for(int i=data.length-1;i>0;i--){
		int temp=data[0];
		data[0]=data[i];
		data[i]=temp;
		maxHeapify(data,i,0);
		}
		}
		 
		/**
		*���ڵ�λ��
		*
		*@paramcurrent
		*@return
		*/
		private static int getParentIndex(int current){
		return(current-1)>>1;
		}
		 
		/**
		*���ӽڵ�positionע�����ţ��ӷ����ȼ�����
		*
		*@paramcurrent
		*@return
		*/
		private static int getChildLeftIndex(int current){
		return(current<<1)+1;
		}
		 
		/**
		*���ӽڵ�position
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
		*��2Ϊ�׵Ķ���
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
	        	//���Ʒ�Ϊincrement�����飬ÿ�����鵥�����бȽ�
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
