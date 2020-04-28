package com.allen.testalgorithm.tree

import org.junit.Test

/**
 * Created by allen on 20/4/27.
 */
class BinarySearchTree {
    var node: TreeNode? = null
    fun query(data: Int): TreeNode? {
        var p = node
        while (p != null) {
            if (data > p.data) {
                p = p.right
            } else if (data < p.data) {
                p = p.left
            } else {
                return p
            }
        }
        return null
    }

    fun insert(data: Int) {
        if (node == null) {
            node = TreeNode(data, null, null)
            return
        }

        var p = node
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = TreeNode(data, null, null)
                    break
                }
                p = p.right
            } else {
                // data < p.data
                if (p.left == null) {
                    p.left = TreeNode(data, null, null)
                    break
                }
                p = p.left
            }
        }
    }

    fun delete(data: Int) {
        var p = node
        var pp: TreeNode? = null
        while (p != null) {
            if (data > p.data) {
                pp = p
                p = p.right
            } else if (data < p.data) {
                pp = p
                p = p.left
            } else {
                break
            }
        }

        if (p == null) {
            // not found
            return
        }

        if (p.left != null && p.right != null) {
            var minP = p.right
            var minPP = p
            while (minP?.left != null) {
                minPP = minP
                minP = minP.left
            }

            p.data = minP!!.data
            p = minP
            pp = minPP
        }

        var child: TreeNode?
        if (p.right != null) {
            child = p.right
        } else if (p.left != null) {
            child = p.left
        } else {
            child = null
        }


        if (pp == null) {
            node = child
        } else if(pp.left==p) {
            pp.left=child
        } else{
            pp.right=child
        }
    }
}

class BinarySearchTreeTest {
    @Test
    fun test() {
        val binarySearchTree = BinarySearchTree()
        binarySearchTree.insert(5)
        binarySearchTree.insert(3)
        binarySearchTree.insert(7)
        binarySearchTree.insert(4)
        binarySearchTree.insert(6)
        binarySearchTree.insert(2)
        binarySearchTree.insert(9)

        println(
            "the sub left tree of 5 : ${binarySearchTree.query(5)?.left?.data}, the sub right tree of 5: ${
            binarySearchTree.query(5)?.right?.data
            }"
        )

        binarySearchTree.delete(4)
        println(
            "after deleting 4, the sub left tree of 3 : ${binarySearchTree.query(3)?.left?.data}, the sub right tree of 3: ${
            binarySearchTree.query(3)?.right?.data
            }"
        )

        binarySearchTree.delete(5)
        println(
            "after deleting 5, the sub left tree of 3 : ${binarySearchTree.query(7)?.left?.data}, the sub right tree of 3: ${
            binarySearchTree.query(7)?.right?.data
            }"
        )
    }
}