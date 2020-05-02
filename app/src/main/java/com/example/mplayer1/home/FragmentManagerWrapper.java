package com.example.mplayer1.home;

import com.example.mplayer1.base.BaseFragment;
import com.example.mplayer1.home.navfrag.HomeFragment;

import java.util.HashMap;

public class FragmentManagerWrapper {

    /**
     * 单利模式
     */
    private volatile static FragmentManagerWrapper mInstance=null;

    public static FragmentManagerWrapper getInstance(){ //单例模式 只创建一个
        if (mInstance==null){
            synchronized (FragmentManagerWrapper.class){
                if (mInstance==null){
                    mInstance=new FragmentManagerWrapper();
                }
            }
        }
        return mInstance;
    }

    private HashMap<String, BaseFragment> mHashMap=new HashMap<>();

    public BaseFragment createFragment(Class<?> clazz,boolean isobtain){
        BaseFragment resultFrament=null;
        String className=clazz.getName();
        if (mHashMap.containsKey(className)){

            try {
                Object object= (Class.forName(className));
                resultFrament=(BaseFragment) object;

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if (isobtain){
            mHashMap.put(className,resultFrament);
        }
        return resultFrament;
    }


}
