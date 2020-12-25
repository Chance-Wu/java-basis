package com.chance.designpatterns.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 组合模式 Composite 定义树枝节点
 * @Author: chance
 * @Date: 12/25/20 2:00 PM
 * @Version 1.0
 */
public class Composite extends Component {

    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    /***
     * 操作有关子部件的实现
     */

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(sb.append(name));
        for (Component component : children) {
            component.display(depth + 2);
        }
    }
}
