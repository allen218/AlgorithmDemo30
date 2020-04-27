package com.allen.testalgorithm.tree

import org.junit.Test

/**
 * Created by allen on 20/4/27.
 */
class RecurseTree {
    fun preOrder(node: TreeNode?) {
        if (node == null) {
            return
        }

        printTreeNode(node)
        preOrder(node.left)
        preOrder(node.right)
    }

    fun midOrder(node: TreeNode?) {
        if (node == null) {
            return
        }

        preOrder(node.left)
        printTreeNode(node)
        preOrder(node.right)
    }

    fun lastOrder(node: TreeNode?) {
        if (node == null) {
            return
        }

        preOrder(node.left)
        preOrder(node.right)
        printTreeNode(node)
    }

    private fun printTreeNode(node: TreeNode) {
        print("${node.data},")
    }
}

class TreeNode(
    val data: Int,
    val left: TreeNode?,
    val right: TreeNode?
)

class Test {
    @Test
    fun test() {
        val node10 = TreeNode(9, null, null)
        val node9 = TreeNode(6, null, null)
        val node8 = TreeNode(7, node9, node10)
        val node7 = TreeNode(4, null, null)
        val node6 = TreeNode(2, null, null)
        val node5 = TreeNode(3, node6, node7)
        val node4 = TreeNode(5, node5, node8)

        val recurseTree = RecurseTree()
        println("recurse the binary search tree by previous order: ")
        recurseTree.preOrder(node4)
        println()
        println("recurse the binary search tree by middle order: ")
        recurseTree.midOrder(node4)
        println()
        println("recurse the binary search tree by last order: ")
        recurseTree.lastOrder(node4)
    }
}
