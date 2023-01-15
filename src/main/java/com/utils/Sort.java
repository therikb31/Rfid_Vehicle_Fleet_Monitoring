package com.utils;

import java.util.Collections;
import java.util.Vector;

import com.models.Pole;

public class Sort {
	public static Vector<Pole> sortPoleVector(Vector<Pole> arr) {
		int len = arr.size();
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if(arr.elementAt(i).getActivity() < arr.elementAt(j).getActivity()) {
					Collections.swap(arr, i, j);
				}
			}
		}
		return arr;
	}

}
