package SJ_4.FruitStoreObj.UI;

import SJ_4.FruitStoreObj.Manager.Manager;

import java.util.Scanner;

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
public class FruitUI {
    private Scanner sc = new Scanner(System.in);
    //调用管理类的方法，属性，实例化管理类对象
    Manager fruitmanager = new Manager();

    //打印菜单
    public void showList() {
        System.out.println("==========水果超市==========");
        System.out.println("【1】购买苹果");
        System.out.println("【2】购买橘子");
        System.out.println("【3】购买香蕉");
        System.out.println("【4】显示选中商品");
        System.out.println("【5】结账");
        System.out.println("【6】打印小票");
        System.out.println("【7】退出系统");
        System.out.println("============================");
        Scanner sca = new Scanner(System.in);
        userSelect(sca);
    }

    /**
     * 选择水果
     * 此方法要对数组进行操作，引入mananer的Fruit【】数组
     */
    public void userSelect(Scanner sc) {
        //提示输入选项
        System.out.println("请输入相应选项：");
        int inpo = sc.nextInt();
        switch (inpo) {
            case 1:
                //增加苹果进数组
                fruitmanager.BuyFruit(1, sc);
                break;
            case 2:
                //增加橘子进数组
                fruitmanager.BuyFruit(2, sc);
                break;
            case 3:
                //增加香蕉进数组
                fruitmanager.BuyFruit(3, sc);
                break;
            case 4:
                //打印选中水果
                System.out.println("sssssss");
                fruitmanager.printfruits();
                break;
            case 5:
                //结账
                fruitmanager.PayOff(sc);
                break;
            case 6:
                //打印小票
                fruitmanager.PrintList(sc);
                break;
            case 7:
                //退出系统
                System.exit(0);
                break;
            default:
                System.out.println("你的选择有误！");
                break;
        }
        //询问用户是否继续
        System.out.println("继续选择y/按任意键完全退出");
        if (sc.next().equals("y")) {
            userSelect(sc); //如果用户选择y就递归调用继续选择
        }

    }


}
