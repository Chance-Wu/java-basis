package com.chance.designpatterns.patterns.composite;

/**
 * @Description: 叶节点：叶节点没有子节点
 * @Author: chance
 * @Date: 12/25/20 1:50 PM
 * @Version 1.0
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    /**
     * 由于叶子节点没有再增加分支和树叶，所有add和remove方法实现它没有意义，
     * 但这样做可以消除叶节点和直接点对象在抽象层次的区别，它们具备完全一致的接口
     */

    @Override
    public void add(Component c) {
        System.out.println("Cannot add to a leaf");
    }

    @Override
    public void remove(Component c) {
        System.out.println("Cannot remove from a leaf");
    }

    /**
     * 叶节点的具体方法，此处显示其名称和级别
     */
    @Override
    public void display(int depth) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(sb.append(name));
    }
}
