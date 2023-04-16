package com.algorithmclass.task.LessonTask001;

import java.util.LinkedList;

/**
 * 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class LessonM002 {
    public LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> returnLinked = new LinkedList<Integer>();
        int addBit = 0;
        while (!l1.isEmpty() && !l2.isEmpty()) {
            Integer current = l1.poll() + l2.removeLast() + addBit;
            if (current > 9) {
                addBit = 1;
            } else {
                addBit = 0;
            }
            returnLinked.offer(current - 10);
        }

        return returnLinked;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode returnNode = null;
        int addBit = 0;
        do {
            Integer current = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + addBit;
            if (current > 9) {
                addBit = 1;
                /* 需要进位 */
                current = current - 10;
            } else {
                addBit = 0;
            }
            /**
             * 套壳
             */
            // returnNode = new ListNode(current,returnNode);
            /**
             * 下钻
             */

            if (returnNode == null) {
                System.out.println("init current--------" + current);
                returnNode = new ListNode(current, null);
            } else {
                ListNode nextNode = returnNode;
                while (nextNode.next != null) {
                    System.out.println("find----val:::" + nextNode.val);
                    if (nextNode.next == null) {
                        break;
                    } else {
                        nextNode = nextNode.next;
                    }
                }
                System.out.println("add current--------" + current);
                nextNode.next = new ListNode(current, null);
                System.out.println("check node: " + nextNode);
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        } while (l1 != null || l2 != null);
        if (addBit > 0) {
            ListNode nextNode = returnNode;
            while (nextNode.next != null) {
                System.out.println("find----val:::" + nextNode.val);
                if (nextNode.next == null) {
                    break;
                } else {
                    nextNode = nextNode.next;
                }
            }
            nextNode.next = new ListNode(addBit, null);
        }
        return returnNode;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.push(3);
        l1.push(4);
        l1.push(2);
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public int get(){
        
    }
}
