package com.example.demo;


/**
 * Created by constanting on 2018/6/3.
 */
public class ref {

    private String name;
    private String age;

    public ref() {
    }

    ;

    public ref(String name, String age) {
        this.name = name;
        this.age = age;
    }
    //int[] nums = {10,11,12, 14, 19};
    public static int binarySearch(int[] arr, int x) {
//        int low = 0;//0
//        int high = arr.length - 1;//4
//        while (low <= high) {
//            int middle = (low + high) / 2;
//            if (x == arr[middle]) {
//                return middle;
//            } else if (x < arr[middle]) {
//                high = middle - 1;
//            } else {
//                low = middle + 1;
//            }
//        }
//        return -1;
        int start = 0;
        int end = arr.length-1;
        while (start<end){
            int center = (start+end)/2;
            if(x == arr[center]){
                return center;
            }else if(x<arr[center]){
                end = center-1;
            }else{
                start = center+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
//        Class demo = Class.forName("com.example.demo.ref");
//        Constructor con = demo.getConstructor(String.class,String.class);
//        Object obj = con.newInstance("xiaoming","18");
//        Constructor con2 = demo.getConstructor();
//        Object obj2 = con2.newInstance();
//
//        Method method = demo.getMethod("refDemo2");
//        method.invoke(obj);

//        Class demo = Class.forName("com.example.demo.ref");
//        Constructor con = demo.getConstructor(String.class,String.class);
//        Object obj = con.newInstance();
//        Method method = demo.getMethod("refDemo2");
//        method.invoke(obj);
//        Class demo = Class.forName("com.example.demo.ref");
//        Method method = demo.getMethod("refDemo",String.class);
//        method.invoke(demo.newInstance(),"hello");


//        MethodAccessor methodAccessor = MethodAccessor.class;
//        ref r = new ref();
//        MethodAccess methodAccess = MethodAccess.get(ref.class);
//        int index = methodAccess.getIndex("refDemo");
//        methodAccess.invoke(r,index);

//        ConstructorAccess constructorAccess = ConstructorAccess.get(ref.class);
//        ref userService = constructorAccess.newInstance();

        int[] nums = {10,11,12, 14, 19, 20};
        System.out.println(binarySearch(nums, 20));
//        for (int i = 0; i <nums.length-1 ; i++) {
//            for (int j = 0; j < nums.length-1-i; j++) {
//                if (nums[j]>nums[j+1]){
//                    int b = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = b;
//                }
//            }
//        }


//        for (int num :nums){
//            System.out.println(num);
//        }


    }

    public void refDemo(String obj) {
        System.out.println(obj);
    }

    public void refDemo2() {
        System.out.println(name + "--" + age);
//        System.out.println(str);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public static int binarySearch(int[] nums,int index){
//        int start = 0;
//        int end = nums.length-1;
//        int center = (start+end)/2;
//        while (start<end){
//            if(index == nums[center]){
//                return center;
//            }else if(index<nums[center]){
//                end = center-1;
//
//            }else if(index>nums[center]){
//                start = center+1;
//            }
//        }
//        return -1;
//    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}
