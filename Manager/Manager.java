package SJ_4.FruitStoreObj.Manager;

/**
 * 类描述了
 * <p>
 * <p>
 * <p>
 * 修改时间： 2019/3/26
 *
 * @author shenyingming tel:18076220793
 * @version 1.0 <br>
 */

import SJ_4.FruitStoreObj.pojo.Apple;
import SJ_4.FruitStoreObj.pojo.Banana;
import SJ_4.FruitStoreObj.pojo.Fruit;
import SJ_4.FruitStoreObj.pojo.Orange;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 数据处理
 * 利用数组装数据
 * 对数据的增，删，改，查
 */
public class Manager {
    //新建水果数组
    public static Fruit fruits[] = new Fruit[5];
    //申明变量表示数组里的水果条数，初始化为零
    public static int counts = 0;

    //【添加数组元素】,只需要录入水果id和数量
    public  void addFruit(int i, int count) {
        if (counts < 5) {
            switch (i) {
                case 1:
                    //提示输入数量

                    fruits[counts] = new Apple(i, count);
                    counts++;
                    break;
                case 2:
                    //提示输入数量
                    System.out.println("请输入橘子数量：");
                    fruits[counts] = new Orange(i, count);
                    counts++;
                    break;
                case 3:
                    //提示输入数量
                    System.out.println("请输入香蕉数量：");
                    fruits[counts] = new Banana(i, count);
                    counts++;
                    break;
                default:
                    System.out.println("商品编号为1至3！本次录入不成功！");
                    break;
            }

        }
    }

    /**
     * 封装增加水果方法
     */
    public void BuyFruit (int i,Scanner sc){
        System.out.println("请输入数量：");
        //将数量以count表示
        int count = sc.nextInt();
        //增加数组元素
        addFruit(i, count);
    }

    /**
     * 结账
     */
    public void PayOff(Scanner sc) {
        //显示消费总额
        double tol = Manager.TotalCharge();  //消费总额
        System.out.println("您的消费总额为：￥" + tol);
        boolean flag = false;
        do {
            //输入用户金额
            System.out.println("请输入您的😊🙉金额：");
            double RMB = sc.nextDouble();
            //结算
            if (RMB > tol) {
                System.out.println("收您：￥" + RMB +
                        "\t消费：￥" + tol +
                        "\t找零：￥" + (RMB - tol));
            } else {
                flag = true;   //金额不足需重新输入
                System.out.println("对不起，金额不足！");
            }
        } while (flag);
    }

    //打印小票

    public void PrintList(Scanner sc) {

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ssE");
        double toltal = Manager.TotalCharge();   //double类型的计算要注意小数
        DecimalFormat df = new DecimalFormat("#0.00");
        String tol = df.format(toltal);    //返回值为string类型

        System.out.println("************欢迎光临不要钱水果摊儿************");
        System.out.println("您购买了如下商品:________________________");
        System.out.println(Manager.fruitsIfo());   //商品信息
        System.out.println("总花费：￥" + df.format(toltal));
        System.out.println("当前日期：\t\t" + sd.format(new Date()));
        System.out.println("***************************大冲分店祝您生活愉快");

    }

    //计算数组内商品总价
    public static double TotalCharge() {
        double charge = 0;

        for (int i = 0; i < counts; i++) {
            charge += fruits[i].getPrice() * fruits[i].getCouunt();   //单价乘数量
        }
        return charge;
    }

    //打印已选择
    public void printfruits() {
        System.out.println(fruitsIfo());
    }

    //打印数组信息
    public static String fruitsIfo() {
        StringBuffer info = new StringBuffer("");
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] != null) {
                info.append(fruits[i].toString() + "\n");
            }
        }
        return new String(info);
    }
}
