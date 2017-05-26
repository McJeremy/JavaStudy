package com.xuzz.study.core;

import com.sun.deploy.util.StringUtils;
import com.xuzz.study.algorithm.sorts.InsertSort;
import com.xuzz.study.algorithm.sorts.QuickSort;
import com.xuzz.study.algorithm.sorts.SelectSort;
import com.xuzz.study.annotation.Apple;
import com.xuzz.study.annotation.FruitInfoUtil;
import com.xuzz.study.aop01.AopMath;
import com.xuzz.study.io.EnumTest;
import com.xuzz.study.net.URLDecoderTest;
import com.xuzz.study.nio.BasicBuffer;
import com.xuzz.study.nio.netty.HelloClient;
import com.xuzz.study.nio.netty.HelloServer;
import com.xuzz.study.thread.*;
import com.xuzz.study.util.BigMoney;
import com.xuzz.study.util.EncryptUtil;
import com.xuzz.study.util.MathUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xuzz on 2016/10/22.
 */
public class Main {
    public static void main(String[] args) throws Exception
    {
       /* Properties prop = System.getProperties();
        prop.store(new FileOutputStream("sys.properties"),"systemproperties");*/
//        System.out.println(new Date());
        /*IStudy study = null;
        //study = new FirstThread();
        //study = new SecondThread();
       // study = new JoinThread("");
        //study= new DaemonThread();
        //study = new DrawThread();

        study = new URLDecoderTest();
        study.runConsole();*/
/*
        FruitInfoUtil.getFruitInfo(Apple.class);*/


//        System.out.println(StringUtils.splitString("proxypr23423535","pr")[0]);

       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        int day1 =cal.get(Calendar.DAY_OF_YEAR);

        String da="2016-12-31 10:00:00";
        Date dateParse = sdf.parse(da);
        cal.setTime(dateParse);
        int day2 =cal.get(Calendar.DAY_OF_YEAR);


        da="2017-1-2 10:00:00";
        dateParse = sdf.parse(da);
        cal.setTime(dateParse);
        cal.add(Calendar.DAY_OF_YEAR,-1);
        int day3 =cal.get(Calendar.DAY_OF_YEAR);
        System.out.println(day2);
        System.out.println(day3);

        System.out.println(getDistanceDays("2016-12-31 10:00:00","2016-12-31 13:00:00"));*/

        /*ApplicationContext ac = new ClassPathXmlApplicationContext("aop01.xml");
        AopMath math =ac.getBean("math",AopMath.class);
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);

        ApplicationContext ac2 = new ClassPathXmlApplicationContext("aop02.xml");
        AopMath math2 =ac.getBean("math02",AopMath.class);
        math2.add(n1, n2);
        math2.sub(n1, n2);
        math2.mut(n1, n2);
        math2.div(n1, n2);*/

//        float rate=0.16f;
//        System.out.println(MathUtil.build(rate).doubleValue());
      /*  Double total = 310.00;
        Double rate = 0.16;
        System.out.println(total*rate);

        double payLimit =5000.00;
        BigDecimal tmpSettleAmount =new BigDecimal(49.60);
        BigDecimal[] xAmount = tmpSettleAmount.divideAndRemainder(MathUtil.build(payLimit));
//        System.out.println(xAmount[0]);
//        System.out.println(xAmount[1]);
//        System.out.println(20.8/5000);
        System.out.println(xAmount[1].doubleValue());
        System.out.println(BigMoney.parseMoney(xAmount[1].doubleValue()));
        System.out.println(MathUtil.build(xAmount[1].doubleValue()));*/

//        System.out.println(BigMoney.add(10.03,9.26));

       /* String s = "2017030809590099100021hx123466";
        System.out.println("2017030809590099100021".length());
        System.out.println(s.indexOf("hx"));
        System.out.println(s.substring(0,s.indexOf("hx")));*/

      /* double ex=-1.0;
       long x = 1;
       System.out.println(ex==-1);*/

        //System.out.println(EncryptUtil.md5Digest("WANGGUO1206HXTXxINJSD"));

//        BasicBuffer.get();


       /* CallableAndFuture.c();
        CallableAndFuture.c2();
        CallableAndFuture.c3();*/

//       ForkJoin.forkJoin();

//        Test1 t1=new Test1();
//        t1.synWithLock();

//        new EnumTest().Entry();
//        BigDecimal bg = new BigDecimal("-0.01");
//        System.out.print(bg.toPlainString());

//        MainSub1002.runWithWait();
//        MainSub1002.runWithCondition();

//        new QuickSort().run();
//        new InsertSort().run();
//        new SelectSort().run();

       /*BigDecimal bg = new BigDecimal(Double.toString(2.455675));

        BigDecimal bg1 = new BigDecimal(2.455675);
        System.out.println(bg);
        System.out.println(bg1);*/

//       String d1="2016-12-31 20:20:00";
//       String d2="2017-01-01 20:19:01";
//
//       System.out.println(compareDate(d1,d2));

        new HelloServer().startListening();
        new HelloClient().connect();

    }

    public static int compareDate(String DATE1, String DATE2) {
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         try {
                 Date dt1 = df.parse(DATE1);
                 Date dt2 = df.parse(DATE2);
                 if (dt1.getTime() > dt2.getTime()) {
                         System.out.println("dt1 在dt2前");
                         return 1;
                     } else if (dt1.getTime() < dt2.getTime()) {
                          System.out.println("dt1在dt2后");
                          return -1;
                      } else {
                          return 0;
                      }
              } catch (Exception exception) {
                  exception.printStackTrace();
              }
             return 0;
         }
    public static long getDistanceDays(String str1, String str2) throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date one;
        Date two;
        long days=0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    public static long getDistanceDays(Date d1,Date d2) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return getDistanceDays(df.format(d1),df.format(d2));
    }
}
