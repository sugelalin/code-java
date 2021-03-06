package org.example.practicecode.structure.treeNode;

import org.example.practicecode.structure.utils.TreeUtil;
import org.junit.Test;

public class TreeNodeTest {

    @Test
    public void test() {
        TreeNode root = TreeUtil.buildBinaryTree((int)Math.pow(2, 3) - 1);
        TreeUtil.traverseLevelFirst(root);
    }

    @Test
    public void testNNode() {
        TreeNNode root = TreeUtil.buildNTree(7, 3);
        TreeUtil.traverseNNode(root);
    }

}
