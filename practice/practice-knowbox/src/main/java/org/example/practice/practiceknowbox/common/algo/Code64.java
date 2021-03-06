package org.example.practice.practiceknowbox.common.algo;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 简单的可逆加解密
 *
 * @author yijiu.chen
 * @date 2020/04/16
 */
public class Code64 {
    private static final char[][] digits = {
        {'i', 'f', 'y', 'L', 'c', '9', 'g', 'm', '2', 'z', 'N', 'q', '7', 'o', 'F', 'u', 'J', 'X', 'x', 'n', 'Q', 'U',
            'Z', '-', 'D', '_', 'S', 'B', 'l', 'I', 'E', '1', 'G', 'V', 'C', 'K', '0', 'T', '6', '8', 'v', '3', 'P',
            'O', '4', 'p', 'd', 'R', 'H', 'h', 'Y', 'A', 'M', 'w', 'j', 's', 'a', 'W', 't', 'k', '5', 'e', 'r', 'b'},
        {'k', 'a', 'S', 'l', 'L', 'W', 't', '1', 'J', 'z', 'A', '0', 'e', '9', 'D', 'Q', 'N', 'n', 'H', 'j', 'R', 'q',
            'g', '6', 'd', 'E', '-', 'y', 'V', 'v', 'I', 'T', 'G', 'F', 'm', '7', '4', 'c', 'x', '3', '8', '5', 'f',
            'b', 'B', 'X', 's', '_', 'U', 'K', 'p', '2', 'M', 'u', 'C', 'O', 'w', 'Y', 'i', 'o', 'r', 'h', 'P', 'Z'},
        {'l', '0', 'q', '3', '4', '7', 'F', 'm', 's', 'P', 'L', 'h', 'X', 'f', 'A', 'n', '6', 'u', 'y', '_', 'G', 'v',
            'e', 'B', 'J', 'D', 'Z', 'O', 'E', 'c', 'r', 'z', 'b', 'C', 't', 'W', '1', 'd', 'I', 'p', '5', 'k', 'T',
            'V', 'R', 'i', 'w', 'a', 'K', '-', 'Y', 'g', 'o', 'S', 'U', 'N', '8', 'j', '9', 'M', '2', 'Q', 'H', 'x'},
        {'N', 'c', 'H', '0', '-', 'J', '_', 'k', 'F', 'O', 'r', 'U', 'V', 'a', '9', 'u', 'd', 'b', 'W', 'o', 'D', 'h',
            '6', '1', '4', 'L', '2', '3', 'G', 'S', 'z', '8', 'X', 'v', 'M', 'I', 'y', 'Z', 'm', 'x', 'w', 'K', 'A',
            'n', 's', 'B', 'q', 'Y', 'P', 'C', 'j', 'g', 'E', 'l', 'i', '7', 'Q', 'p', 'e', 'R', 'T', 'f', '5', 't'},
        {'6', '5', '-', 'N', 'g', 'd', 'I', 't', 'F', 'V', 'Q', 'R', 'v', 'h', 'T', 'X', 'i', '9', 'C', 'W', 'M', 'r',
            '8', '_', 'E', 'n', '0', 'B', 'K', 'k', 'o', 'S', '2', 'f', 'u', 'x', 'O', 'A', 'l', 'U', '3', 'j', 'z',
            'y', '4', 'J', 'D', 's', 'Y', 'e', '7', 'q', 'G', 'c', 'm', 'P', 'H', '1', 'a', 'Z', 'b', 'w', 'L', 'p'},
        {'8', '2', 'y', 'J', 'r', 'M', 'l', 'b', 's', 'T', 'P', 'D', 'e', 'S', '5', '-', 'V', 'h', 'm', 'N', 'z', '0',
            'o', 'u', 'Y', 'E', '9', 'Q', 'L', 'c', 'R', '4', 'U', '7', 'H', 'v', '6', 'j', 'F', 'B', 'f', 'n', 'K',
            'I', 'X', 't', '3', '1', 'q', 'g', 'k', '_', 'A', 'C', 'W', 'i', 'G', 'p', 'd', 'w', 'O', 'a', 'Z', 'x'},
        {'A', 'C', '0', '6', 'R', 'F', 'X', '7', 'I', 'g', '8', 's', '4', 'h', 'W', '5', '3', 'd', 't', 'c', '1', 'J',
            'T', 'E', 'f', 'b', 'Z', 'G', 'U', 'V', 'Y', '_', '2', 'N', 'D', 'v', 'j', 'k', 'w', 'l', 'L', 'y', 'x',
            'S', '9', 'Q', 'u', 'M', 'o', '-', 'n', 'e', 'm', 'K', 'H', 'z', 'P', 'B', 'q', 'p', 'r', 'i', 'O', 'a'},
        {'7', 'a', 'G', 'Q', 'B', 'e', 'r', 't', 'K', 'u', 'V', '-', 'C', 'p', 'k', 'Y', '6', 's', 'J', 'F', 'M', 'w',
            'R', 'b', 'D', 'O', 'A', 'I', 'H', 'W', 'P', '9', 'o', 'v', 'E', 'q', 'd', '0', 'n', 'j', 'c', '2', 'm',
            '5', 'T', '1', 'f', 'x', '4', 'l', '_', 'L', 'h', 'S', '8', 'Z', 'g', '3', 'z', 'y', 'N', 'i', 'X', 'U'},
        {'0', 'n', '4', 'p', 'G', 'u', 'a', '9', 'g', 'w', 's', 'F', 'W', 'y', '_', 'i', 'P', 'A', 'D', 'b', 'Q', '5',
            '7', 'e', 'v', 'T', 'K', 'M', 'H', 'Y', 'O', 'q', 'z', 'o', 'E', '6', '2', '3', '1', 'I', '8', 'Z', 'm',
            '-', 'x', 'k', 'U', 'X', 'V', 'N', 'l', 'f', 'h', 'c', 'r', 'S', 'R', 'j', 'B', 'C', 'd', 'J', 't', 'L'},
        {'r', 'L', 'A', 'n', 'W', 'Y', 'V', 'N', 'g', 'X', 'd', 'x', 'R', 'Z', 'c', '-', 'h', 'a', 'U', 'Q', 'j', 'B',
            '0', 'I', 'b', 'k', 'o', 'y', 'J', 'C', '4', '9', 'm', '7', 'G', 'f', 'v', 'l', 'e', 'S', 'T', 'p', 'F',
            'P', 'K', 'w', 'i', 'z', 'H', '_', '6', 'q', 'D', 't', 'u', 'E', 'M', '5', '2', 'O', '1', '3', '8', 's'},
        {'T', 'f', 'U', 'y', 'I', 'F', 'H', 'x', 'k', 'G', 'W', 'Q', 'c', 'O', '7', 'g', 'S', 'L', 'Z', 'd', 'q', '6',
            'z', 'p', 'Y', 'P', 'M', 'D', '5', 'j', 'V', 's', 'J', '0', 'u', 'o', '8', '4', 'h', 'i', 'b', 'v', 'B',
            'N', 'l', '_', 'a', 'A', 't', 'n', 'm', '1', 'w', 'X', 'K', 'r', '3', '2', '9', 'E', 'e', 'R', '-', 'C'},
        {'I', 'S', 'g', 'k', 'L', 'P', 'b', 'j', 'R', 'V', 'r', 'd', 'x', 'q', 'c', 'Z', 'f', 'n', 'M', 'X', 't', 'K',
            'h', 'a', 'E', 'i', 'e', 'p', '8', '1', '7', 'F', '3', '-', 'O', '0', 'T', 'W', 'z', 'A', '6', 'D', '_',
            '4', 'N', 'Q', 'y', '9', 'o', 'Y', 's', 'B', 'H', '5', 'G', 'U', 'J', '2', 'C', 'u', 'l', 'w', 'v', 'm'},
        {'X', '9', 'u', 'm', 'V', '7', 'a', 'J', '0', 'Q', 'O', 's', '1', '_', 'h', 't', 'y', 'n', 'w', '2', 'G', 'P',
            '4', 'U', '-', 'd', 'E', 'H', 'o', 'r', '8', 'F', 'A', 'N', 'K', '6', 'j', 'e', 'S', 'Z', 'T', '5', 'q',
            'M', 'W', 'p', 'C', 'b', 'Y', 'z', 'i', 'x', 'R', 'l', 'I', 'L', 'f', '3', 'c', 'D', 'k', 'g', 'v', 'B'},
        {'R', 'j', 'l', 'B', 't', 'x', 'f', '1', 'C', 'I', 'P', '7', 'b', 'L', 'u', '5', 'K', 'q', 'H', 'E', '9', 's',
            'e', '_', '2', 'o', '8', 'A', 'Z', 'Y', 'h', 'w', 'd', 'M', 'W', 'c', 'V', '0', 'p', 'a', 'n', 'N', 'r',
            'S', 'X', 'i', 'T', 'k', 'y', 'F', 'g', 'J', 'z', 'Q', 'U', '4', '6', 'D', '3', '-', 'm', 'O', 'G', 'v'},
        {'q', 'C', 'V', 'k', 'w', 'i', 'U', 'Q', 't', 'g', 'X', '_', 'A', 'v', 's', 'T', '3', 'P', 'S', 'y', 'p', 'N',
            'Z', 'm', 'Y', 'M', 'l', 'E', '2', '5', 'z', 'K', '1', 'n', 'b', 'e', 'c', 'I', 'u', 'W', 'f', 'D', 'G',
            'h', '6', '0', '4', 'F', 'x', 'o', 'd', 'L', 'R', 'B', '8', '9', '7', 'O', 'H', '-', 'J', 'r', 'a', 'j'},
        {'n', '3', '0', 'p', 'T', 'D', 's', 'y', 'B', 'd', '_', '7', 'K', 'P', '-', 'q', 't', 'e', 'U', '5', 'S', 'W',
            'i', 'I', 'b', 'x', 'w', 'J', 'g', 'u', 'Y', 'R', 'M', 'Q', '6', 'N', 'v', '2', 'j', 'V', 'O', 'L', 'H',
            'C', 'G', 'o', '1', 'c', '4', 'E', '8', 'r', 'k', 'Z', 'm', 'a', 'F', 'A', 'X', '9', 'z', 'f', 'h', 'l'},
        {'w', '7', 'D', 'o', 'A', 'l', 'I', 'M', 'U', 's', 'G', 'd', 'v', 'V', '1', '9', 'L', 'h', 'r', 'x', 'f', 'B',
            'T', '-', 't', '_', 'a', '2', 'N', '3', 'k', '0', 'e', '5', 'H', '8', 'g', 'F', 'q', 'Y', 'i', 'j', 'K',
            'Z', 'O', 'u', 'W', 'X', '6', 'm', '4', 'C', 'y', 'J', 'E', 'n', 'S', 'p', 'P', 'z', 'R', 'b', 'Q', 'c'},
        {'p', 'l', 'k', '5', 'n', 'w', 'K', 'E', '_', 'P', 'R', 'F', 'o', '1', '2', 'q', 'O', 'h', 'Y', 'i', 'v', '4',
            'Z', 'e', 'b', 'W', 'g', '7', 'f', 'Q', 's', 'N', '8', '-', 'd', 'G', 'c', 'I', 'm', 'y', 'H', 'L', 'j',
            'B', 'T', '9', '6', 'M', 'V', '3', 'z', 'x', 'X', 'J', 'a', 'U', 'D', 'C', '0', 't', 'S', 'u', 'r', 'A'},
        {'m', 'F', 'O', 'T', 'Y', '3', 'U', 'C', 'M', 'h', 'R', 'b', 'o', '1', 'W', '7', 'n', '5', '9', 'I', 'Z', 'd',
            'y', '8', 'a', 'x', 'K', 'V', '_', 'E', 'v', 'l', 'X', 'z', 'j', 'L', 'k', '2', 'Q', 'A', 'B', 'p', 'i',
            'u', '4', 'S', '-', '0', 's', 'c', '6', 'N', 'g', 'f', 'H', 'P', 't', 'r', 'J', 'G', 'D', 'q', 'e', 'w'},
        {'J', 'h', '5', 'b', 'p', 'M', '-', 'Q', 'T', 'o', 'P', 'A', 'q', 'G', '4', 'S', 'g', 'H', 'V', 'O', '2', 'C',
            'D', '7', '8', 'Z', 'E', 'X', 'R', 's', 'j', 'c', 't', 'B', 'N', 'i', 'K', '9', 'm', '_', '0', 'a', 'W',
            'Y', 'u', 'U', 'n', 'r', 'y', '1', '6', 'z', '3', 'F', 'x', 'L', 'l', 'f', 'k', 'd', 'v', 'e', 'I', 'w'},
        {'O', 'S', 'i', '6', 'U', '9', 'u', '8', 'T', '4', 'G', 'a', 'v', 'D', 'j', 's', 'h', 'R', '5', 'A', 'm', '-',
            'M', 'p', '0', 'f', 'V', 'L', '3', 'r', 'd', 'B', 'b', 'k', 'Z', 'H', 'J', 'e', 'y', 'X', '_', 'o', 'K',
            'c', 'P', '2', '1', 'q', 'I', 'Y', 'l', 'n', 'g', 't', 'E', 'Q', 'x', 'W', 'w', 'F', '7', 'N', 'z', 'C'},
        {'f', 'H', 'p', 'Y', 'r', 'I', '8', '2', '0', 'K', 'a', 'O', 'x', 'q', 'S', 'j', 'w', 'D', 'A', '1', 'h', '-',
            'F', 'l', 'P', '_', 's', '4', 'y', 'N', 'u', '7', 'X', 'U', 'M', 'd', '9', 'Q', 'g', 'T', 'E', '3', 'b',
            'R', 'B', '5', 'L', 'c', 'J', 'e', 'W', 'n', 'C', 'm', 'Z', 'V', 't', '6', 'k', 'i', 'v', 'o', 'z', 'G'},
        {'1', '8', 'b', '2', 'L', 'D', 'k', 'a', 'f', 'l', 'I', 'r', '3', 'R', 'W', 'V', '0', '_', 'j', 't', 'i', 's',
            'y', 'p', 'u', 'c', 'T', '7', 'O', 'x', 'Y', 'J', 'Q', 'M', 'F', 'G', 'E', 'm', 'K', 'Z', 'v', '4', 'd',
            'N', 'H', 'e', 'h', 'B', 'n', 'X', 'C', '5', 'S', 'w', '6', '9', 'o', 'g', 'P', 'z', '-', 'U', 'A', 'q'},
        {'F', 'v', 'j', 'd', 'I', 'e', '3', '2', '-', '9', 'A', 'L', 'u', '0', 'x', 'w', 'O', 'U', '1', '_', 'c', 't',
            's', 'q', 'W', 'T', 'z', 'E', 'Y', 'i', 'V', '8', 'B', 'a', 'G', 'K', 'M', 'N', 'S', 'R', 'P', 'H', 'X',
            '5', 'l', '7', '6', 'm', 'y', 'h', '4', 'J', 'D', 'Z', 'f', 'g', 'o', 'k', 'p', 'C', 'b', 'n', 'r', 'Q'},
        {'x', 'Q', 'V', '7', 'q', 'I', '8', 'D', 'E', 'z', 'B', 'p', '_', '2', '5', '1', 'w', 'c', 'y', 'O', 'i', 's',
            '6', 'l', 'U', 'W', 'Z', 'g', 'H', 'N', 'j', 'h', 'T', 'r', 'd', '0', '-', 'v', 'u', 'a', 'm', 'n', 'G',
            't', 'M', 'S', 'A', 'X', 'R', '3', 'C', 'F', 'K', '4', 'o', 'L', 'b', 'J', 'k', 'f', 'e', '9', 'P', 'Y'},
        {'_', 'L', 'j', 'E', 'k', 'm', 'C', 'b', 'e', 'R', '5', 'p', 'n', 'I', 'N', '0', 'Y', '7', 'P', 'u', '2', 'F',
            'V', 't', 'o', 'S', 'c', 'v', 'r', 'g', 'X', 'l', '8', 'U', 'M', 'Z', 'J', '3', 'O', 'x', 'a', '6', 'w',
            'Q', 'T', 'd', 'y', 'i', 'H', 'B', 's', 'A', 'f', 'q', 'G', '9', '4', 'K', 'D', 'z', 'h', '-', 'W', '1'},
        {'4', 'k', 'A', 'Q', 'r', 'g', 'L', '3', 'm', 'p', 'd', 'f', 'a', 'u', 'l', 'i', 'X', 'Y', 'J', 'q', 'z', 'x',
            'v', 'V', '2', '6', 'e', 'o', 'R', 'j', 't', 'G', 'F', 'U', 'b', '7', '_', 'O', 'C', 'K', '0', 'n', 'P',
            '9', 'N', 'B', 'h', '-', 'M', '5', '1', 'H', 'D', 'W', 'S', 'w', 'c', 'y', 'Z', 'T', 'I', 'E', '8', 's'},
        {'g', 'v', 'O', 'y', 'Q', 'a', 'C', 'f', '-', 'd', '7', '0', '4', 'i', 'w', 'P', '6', 'T', 'p', '5', '9', 'c',
            'J', '_', 'H', 'u', 'm', 'L', '2', 'n', 'x', 'X', 'A', 'D', 's', '3', 'r', 'W', '1', 'h', 'U', 'M', 'k',
            'R', 'o', 'e', 'G', 'B', 'S', 'j', 'E', '8', 'z', 'b', 't', 'Y', 'V', 'Z', 'K', 'q', 'l', 'I', 'F', 'N'},
        {'Q', 'I', '4', '8', '5', 'h', 'z', '9', 'x', 'E', 'f', 'Y', '-', 'P', 'w', 'W', 'v', '6', 'o', 'r', 'd', '3',
            'T', 'n', 'J', 'G', 't', 'C', 'F', 'a', 'K', 'S', '7', 'p', 'Z', '1', 'b', '_', 'U', 'k', 's', 'q', 'u',
            '0', 'O', 'V', 'X', 'e', 'l', 'H', 'L', 'c', 'A', 'B', 'M', '2', 'g', 'm', 'y', 'j', 'D', 'N', 'i', 'R'},
        {'b', 'v', 'r', 'o', '9', 'g', 'q', 't', '_', 'V', '1', 'K', 's', 'J', 'd', 'M', 'H', 'S', 'p', 'O', 'F', 'c',
            'Q', '5', '-', 'y', 'f', 'h', 'l', 'C', 'P', '4', 'm', '7', 'U', 'k', 'a', '0', 'R', 'i', 'L', '3', 'T',
            'u', 'X', 'G', 'Z', 'W', 'D', 'E', '8', 'w', '6', 'A', 'Y', 'x', '2', 'j', 'z', 'N', 'I', 'n', 'e', 'B'},
        {'u', 'z', '3', 'T', '9', 'E', 'P', 'X', 'i', 'M', 'S', 'Y', 'c', 'N', 'n', 'r', 'U', 'v', 'W', 'h', 'I', '4',
            '7', '0', 'V', '-', 'J', 't', '2', 'x', 'p', 'o', 'g', 'y', 'b', 'C', 'l', 'B', 'K', '_', 'R', 'H', 'Q',
            'e', 'F', 'L', 'd', 'A', 'w', 'j', 'G', '5', 'm', 'q', 'Z', 'a', '8', 's', 'f', 'O', '1', 'D', 'k', '6'},
        {'v', 'D', 'Y', 'k', 'V', 'p', 'N', 'G', 'i', 'w', '-', 'M', 'g', 's', 'c', 'Z', 'a', 'H', 'm', 'b', 'o', 'T',
            'x', 'l', 'Q', 'z', 'L', 'h', 'P', '_', 'I', 'X', 'C', 'y', '9', 'e', 'B', 'j', 'n', '8', 'O', 't', '0',
            'A', '3', '1', 'K', 'J', 'u', 'E', 'R', 'q', 'r', '2', '4', 'f', 'S', '5', 'W', 'F', 'd', '6', '7', 'U'},
        {'j', 'O', 'g', 'D', '6', 'l', 'w', 'y', '-', '3', 'N', 'i', 'B', 'z', 'r', 'S', '5', '8', '2', 'o', '0', 'P',
            'm', 'K', 'H', 't', 'X', 'v', 'f', 'M', 'L', 'F', 'k', 'T', 'W', '_', 'Q', 'Z', '1', 'E', 'c', 'C', 'u',
            'd', '4', 's', 'J', 'V', 'A', 'q', 'I', 'n', '7', 'G', 'R', 'x', 'U', 'Y', 'b', 'e', 'p', '9', 'a', 'h'},
        {'a', '5', 'k', 'g', '9', 'h', 'p', '3', '4', 'c', 'l', 'o', 'm', 'V', 'X', '2', 'j', '_', 'i', 'W', 'Y', 'B',
            'f', 'P', 'Q', 'T', '6', 't', 'N', '-', '1', '0', 'r', 'C', 'd', 'M', 'U', 'b', 'F', 'w', 'H', 'L', 'E',
            'x', 'A', 'u', 'I', 'D', 'G', 'z', 'Z', 'R', 'q', 's', '7', 'K', 'J', '8', 'y', 'e', 'S', 'n', 'O', 'v'},
        {'K', '6', '8', 'U', '-', 'A', '7', 'p', 'Y', 'o', 'l', 's', 'k', 'M', 'L', 'r', 'H', 'T', 'g', 'J', 'O', 'q',
            'S', 'x', 'm', 'V', 'h', '1', 'E', 'X', 'G', 'f', 'z', 'u', 'P', 'e', 'n', 'I', 'c', '2', 'i', '0', 'y',
            '4', 't', 'R', 'B', '5', 'F', 'j', 'C', 'a', 'N', 'Q', 'Z', 'b', '_', 'D', 'w', 'd', '9', 'v', '3', 'W'},
        {'P', 'B', 'w', '_', 'p', 'J', 'm', 'Q', 'V', 'k', 'c', 'C', 'v', 'T', 'O', '-', '4', '0', 'I', 'r', 'x', 'b',
            'u', 'U', 'F', '5', '9', '8', 'N', 'D', '7', 'g', 'y', 'a', '1', 'f', 'E', 'A', '6', 'R', 'd', 'h', 'j',
            'M', 'l', '3', 'X', 'z', 'S', 'e', 'n', 'o', 'q', 'L', 'K', 'Z', 'G', 'H', 's', 'W', 'Y', '2', 'i', 't'},
        {'Y', 'r', 'z', 'l', 'o', 'W', 'O', 'y', '6', 'w', '3', 'V', 'i', 'x', '8', 'c', 'N', 'Q', 'C', 'U', 'Z', 'q',
            'E', 'b', 'L', 's', '0', 'J', 'h', '-', 'F', 'R', 'v', '_', '4', 't', '1', '7', 'I', 'T', 'H', 'm', 'd',
            'X', 'D', 'a', '5', 'p', 'S', 'A', 'k', 'P', 'j', 'K', 'g', 'M', '9', 'n', 'u', 'G', 'f', 'B', '2', 'e'},
        {'B', 'h', 'u', 'I', 'Y', 'e', 'O', 'j', '3', 'D', 'a', 'X', 'm', '0', 'F', 'C', 'o', 'M', 'w', '-', 'A', 'Q',
            'd', 'R', 'E', 'b', 'L', 's', 'i', 'z', '7', 'k', 'V', '9', '1', '4', 'J', 'S', '_', '6', 'c', 'H', '5',
            'r', 'Z', 'v', 'T', 't', 'N', 'f', 'x', 'P', 'n', 'K', 'G', 'U', 'y', 'l', '8', 'q', 'W', 'g', '2', 'p'},
        {'M', '9', 'A', 'S', 'x', 'd', 'C', 'l', 'U', 'T', 'u', 'W', 'O', 'J', 'F', 'm', '6', 'b', 'Q', 'a', '0', '-',
            'H', 'v', '1', 'R', 's', 'i', 'V', 'P', 'g', 'E', 'o', 'e', '3', '7', '2', 'p', 'h', 'L', 'n', '8', 'k',
            'r', 'Z', 'f', 'w', 'X', 't', 'y', '5', 'N', '4', 'D', 'I', '_', 'Y', 'B', 'q', 'j', 'z', 'K', 'c', 'G'},
        {'9', 'u', 'U', '2', 'p', '-', '5', 'a', 'L', 'P', 'w', '7', 'k', 'b', 'f', 'F', 'N', 'C', 'O', 'v', 'c', 'M',
            'e', 'g', '6', 'j', 'D', 'Z', 't', 'd', 'W', 'o', 'Y', 'z', '4', 'n', 'y', 'l', '3', 'm', 'J', 's', 'T',
            'q', 'S', '_', 'r', '1', 'A', 'G', 'R', 'x', '0', 'I', 'Q', 'K', '8', 'X', 'E', 'h', 'H', 'i', 'B', 'V'},
        {'G', 'c', 'L', 'P', '_', 'e', '5', 'p', '7', 'I', 'Q', 'u', 'l', 'm', 'i', 'R', 'S', 'j', 'g', 'x', 'U', 'r',
            '-', 'K', '9', 'T', '1', 'M', 'O', 'B', 'h', '3', 'N', 'b', 'k', 'w', 'q', 'd', 'A', 'C', '6', 'J', 'n',
            'D', 't', 'W', 'X', 'Y', '4', 'V', 'v', 'y', 'H', 'o', '0', 's', 'f', 'a', 'F', '8', 'z', 'Z', 'E', '2'},
        {'H', 'c', 'z', 'O', 'L', 'Q', 'D', '7', 'J', 'k', 'i', 'S', 'X', 'n', 'y', 'Z', 'm', 'R', 'Y', 'A', '_', 'e',
            'N', 't', '2', 'a', 'V', '6', 'C', '8', 'T', 'G', '1', 'l', 'u', 'p', 'K', 'I', 'f', '5', 'F', 'o', 'b',
            '-', 'g', 'v', '0', '4', 'w', 'B', '9', 's', 'q', 'W', 'd', 'x', 'E', 'h', 'r', 'j', 'P', 'M', 'U', '3'},
        {'S', 'b', 'i', '-', 't', 's', 'A', 'r', '7', 'O', 'E', 'k', 'z', 'P', 'K', 'Q', 'R', '6', '9', 'H', 'g', 'v',
            'q', '4', 'C', 'L', 'h', '1', 'J', 'V', 'F', 'w', 'm', 'c', 'p', 'M', '8', '2', '3', 'U', '0', 'd', 'e',
            'Y', 'u', 'f', 'j', 'W', 'T', 'B', '_', 'Z', 'D', 'N', '5', 'l', 'a', 'G', 'I', 'X', 'x', 'o', 'y', 'n'},
        {'o', 'w', 'C', 'W', 'J', 'v', 'E', 'g', 'm', '3', 'V', 'Q', '6', '_', '5', '4', 'S', 'h', 'R', 'H', 'k', 't',
            'F', '1', 'q', '2', 'x', 'i', 'T', 'I', '0', 'L', 'O', 'Y', '8', 'N', 'y', 'A', 'Z', '7', 'b', 'f', 'u',
            'z', 'U', 'P', 'G', 'l', 'X', 'B', 'e', 'K', 'p', 'c', '9', 'd', 'n', 'j', 's', 'D', 'a', 'r', '-', 'M'},
        {'E', 'w', '7', 'm', 't', 'r', 'j', 'B', 'b', 'L', 'i', 'a', 'M', 'v', 'z', '0', 'Q', 'x', 'l', 'o', '2', 's',
            'e', 'g', 'T', 'J', '3', 'K', 'h', 'Z', 'n', 'C', 'y', 'H', 'P', '_', '8', '1', 'S', '4', '5', '-', 'Y',
            'f', 'G', 'W', 'I', 'q', 'F', 'k', 'R', 'O', 'c', 'p', 'd', 'N', '9', 'U', 'X', 'D', 'A', '6', 'u', 'V'},
        {'3', 'H', 'b', '0', '4', 'h', 'o', 'X', 'W', 'u', '6', '1', 'j', 'Y', '8', 'E', 'B', 'A', 'J', 'k', '7', 'm',
            '_', '5', 'z', '9', 'n', 'C', 'e', 'v', 'a', 'T', 'i', 'N', 'L', 'O', 'p', '-', 'c', 'I', 'Q', 'U', 'g',
            'D', 'd', 'S', 'R', 'x', 's', 'K', 'r', 'Z', 'M', 'y', '2', 'V', 't', 'w', 'l', 'F', 'P', 'f', 'q', 'G'},
        {'L', 'j', '6', '_', 'a', 'A', '2', 'n', 's', 'i', 'K', 'f', 'T', '0', 'G', 'w', 'X', '3', 'E', 'y', 'F', 'd',
            'B', 'C', 'I', '8', 'l', 'v', 'p', '1', 'u', 'D', 'c', 'M', 'm', 'J', 'W', 'h', 'g', 'P', 'N', 'R', '5',
            'b', 'z', 'e', 'o', '-', '4', 'Z', 'U', 'V', 'k', 'q', 'Q', '7', 'O', 'S', '9', 't', 'x', 'Y', 'H', 'r'},
        {'W', 'y', '_', 'S', '5', 'h', 't', 'Y', 'B', '-', '2', 'c', 'M', 'D', 'g', 'H', 'p', 's', 'Q', 'q', 'n', 'u',
            'R', 'F', 'k', 'z', 'N', 'w', 'U', 'l', '6', 'E', 'G', 'T', '1', 'A', '7', 'f', '8', '9', 'Z', 'r', 'V',
            'v', 'X', '3', 'C', 'i', 'J', 'a', '0', 'P', '4', 'd', 'L', 'm', 'I', 'b', 'K', 'o', 'j', 'e', 'O', 'x'},
        {'e', 'y', 'H', 'g', 'D', 'b', '4', 'm', 'f', 'v', 'z', '_', 'I', 'l', 's', 'F', 'k', 'a', '8', 't', '3', 'A',
            'p', 'x', 'Y', '1', '-', 'R', 'V', 'n', '0', 'O', 'N', 'Z', '9', 'X', 'o', 'P', 'c', '7', 'W', 'Q', 'q',
            'J', 'U', '6', 'h', 'G', 'u', 'E', 'K', '5', 'C', 'd', 'i', 'r', '2', 'M', 'L', 'S', 'j', 'T', 'B', 'w'},
        {'t', 'a', 'h', '2', 'i', 'w', 'd', 'F', 'm', 'u', 'E', 'L', 'I', '_', 'c', 'r', 'C', 'S', 'G', 'H', 'o', 'b',
            '5', '4', 'R', '6', 'j', 's', 'K', 'A', 'Y', 'k', 'Q', '3', 'f', '1', 'J', 'e', '-', 'g', 'M', 'x', 'P',
            'T', 'B', '0', 'n', 'v', 'V', 'U', 'p', '7', 'O', '8', 'q', 'y', 'l', 'N', 'W', 'Z', 'z', 'X', '9', 'D'},
        {'U', 'Q', 'V', 'J', 'j', '2', 'W', '7', 'E', 'Z', 't', 'b', 'm', 'F', 'f', 'v', 'A', '9', '4', '1', 'h', 'g',
            'N', 'a', '0', 'M', 'k', 'Y', 'L', 'G', 'S', 's', 'w', 'O', 'P', 'x', '-', 'i', '8', 'n', 'p', 'H', 'I',
            'd', 'u', 'z', 'o', 'D', 'c', 'y', 'T', 'X', 'R', 'q', 'e', 'l', '_', '3', '6', 'K', 'C', '5', 'B', 'r'},
        {'z', 'l', 'B', 'f', 'G', 'u', 'w', 's', '8', 'p', 'v', 'q', '1', 'k', '5', 'D', '4', 'd', 'O', '9', 'Q', 'U',
            'r', 'Y', 'T', '_', 'K', 'n', 'i', 'V', 'W', 'S', 'g', '2', 'm', 'e', 'A', '7', '3', 'o', 'h', 'E', '0',
            'x', 'R', 'X', 'F', 'b', 'H', 'M', 't', 'c', 'Z', 'I', 'J', 'C', 'a', 'P', 'y', 'L', '-', '6', 'N', 'j'},
        {'Z', '9', 'k', '7', 'l', 'V', 'v', '1', 'y', 'q', 'P', 'Y', 'G', 'c', 'X', 'W', '-', 'S', '3', 'J', 'm', 'M',
            'E', 'x', 'r', '6', 'f', 'H', 'Q', '0', 'U', 'w', 'T', 'B', 'a', 'i', 'I', 'K', 'h', 'z', '2', 'u', 'b',
            '_', '5', 'O', 'A', 'n', 'F', '4', 'C', 't', '8', 'd', 'R', 'j', 'N', 'L', 'g', 's', 'D', 'p', 'o', 'e'},
        {'D', 'Q', 'H', 'p', '3', '_', 'M', 'G', 'c', 'o', 'f', '5', 'Z', '6', '7', 'L', 'e', 'J', 'z', '2', '9', 'x',
            'E', 'q', '-', 'k', 'm', '4', 'K', '8', 'a', '0', 'O', 'N', 'w', 's', 'l', 'T', 'R', 'i', 'F', 'W', 't',
            'v', 'y', 'g', 'n', 'P', 'd', 'h', 'A', 'u', 'X', 'U', 'b', 'V', 'r', 'C', 'I', '1', 'S', 'B', 'j', 'Y'},
        {'V', 'Y', 'W', 'u', 'g', 'm', 'b', 't', 'l', '2', 'j', '8', 'z', 'D', 'y', 'T', 'O', '6', 'o', '1', 'N', 'H',
            'Q', 'J', '0', 'p', 'h', 'd', '7', 'Z', 'e', 'c', 'U', 'A', 'f', 'E', 'n', 'v', 's', 'B', '_', 'P', 'F',
            'C', '9', '-', 'S', 'K', 'R', 'a', 'x', 'k', '4', 'i', 'L', 'w', 'M', 'X', 'q', 'I', '5', 'r', 'G', '3'},
        {'h', 'O', 'Y', 'x', 'r', '5', '-', 'j', '2', '8', 'Z', 'R', 'i', 'g', 'A', 'c', 'L', 'm', 'F', 'E', 'z', 'w',
            'f', 'k', '1', 'a', '7', 'u', 'p', '3', 'D', 'I', 'v', 'C', 'd', 's', 'q', 'Q', 'H', 'o', 'T', '4', 'B',
            'M', 'N', 'J', 'W', 'K', 'U', '_', 'e', 'b', 'S', 't', 'P', 'X', '6', 'G', 'n', 'y', '9', 'l', 'V', '0'},
        {'5', 's', 'S', 'A', 'V', 'T', '9', 'X', 'J', 'c', 'Y', '1', 'L', 'g', 'v', 'F', 'u', 'i', 'w', 'y', 'q', 'b',
            'f', 'r', 'n', 'z', 'o', 'H', 'Q', 'a', 'p', '4', '3', 'd', '0', 'M', 'h', 'e', 'O', 'D', 'm', 'C', 'B',
            'U', 'W', 'Z', '6', 'N', '-', '2', 'E', 'G', 'R', '8', 'x', '7', 'K', 'k', 'P', '_', 'I', 't', 'j', 'l'},
        {'d', 's', 'r', '3', 'w', 'g', 't', 'U', 'R', 'f', 'X', 'Y', '8', '5', 'P', '6', 'y', 'K', 'k', 'L', 'a', '4',
            'q', 'G', 'i', '7', 'M', 'n', 'b', 'W', 'm', 'O', '-', 'N', '9', 'p', '1', 'D', 'z', 'I', 'V', 'l', 'B',
            'o', 'Q', 'A', 'T', 'E', 'Z', 'c', 'x', 'h', 'J', 'C', '0', 'u', '_', 'S', 'v', 'F', 'e', '2', 'H', 'j'},
        {'c', '5', 'Q', 't', '0', 'L', '4', '8', 'F', '6', 'k', 'g', 'T', 'w', 'j', 'n', 'd', '-', 'm', 'J', 'B', 'O',
            'i', 'G', 'b', 'y', 'e', 'q', 'A', 'X', '3', 'M', 'r', 'o', 'h', 'U', 'C', 'H', 'l', 's', 'a', 'Z', 'I',
            'z', '_', 'v', '1', 'E', 'x', 'K', 'p', 'Y', 'S', '2', 'R', 'P', '9', 'W', 'V', 'u', 'f', 'N', 'D', '7'},
        {'C', 'x', 'L', 'l', 'P', '6', 'K', '2', '3', 'b', 'V', 't', 'M', 'o', 'B', 'y', '4', 'G', 'p', 'T', 'X', 'R',
            'U', 'r', 'm', 'O', 'v', 'q', 'S', 'e', '8', '_', 'I', 'F', 'D', 'c', 'E', 'n', 'd', 'A', 'Y', '9', 's',
            'N', 'f', 'i', 'h', 'H', 'a', 'z', '7', 'j', 'Z', 'u', '-', 'k', 'w', 'Q', '5', 'g', '0', '1', 'W', 'J'},
        {'s', 'v', 'Z', 'q', 'r', 'X', 'd', 'x', 'N', 'i', 'b', '9', 'V', 'I', 'T', 'L', '2', 'y', 'f', 'h', 'W', '6',
            'p', 'g', 'n', 'A', 'l', 'J', 'c', '0', 'B', 'j', 'o', '7', '4', '_', 'z', 'F', 'k', 'M', 'U', 'w', 'Y',
            '5', '3', 'H', 'C', 'K', 'S', 't', 'P', '1', 'e', 'a', 'R', 'D', '8', 'O', '-', 'Q', 'E', 'u', 'm', 'G'},
        {'-', 'd', '_', 'F', '5', 'Q', '1', 'C', 'T', 'b', 'e', 'q', 'w', 'R', 'X', 'P', 'u', 'a', 'O', '3', 'h', 'x',
            '8', '6', 'c', 'k', 'f', 'n', '2', 'm', 'l', 'J', 'r', 'A', '0', 'K', 'H', 'Y', 's', 'V', 'o', 'I', 'g',
            'M', 'y', 'U', 'Z', '4', 'v', 'G', '7', 'D', '9', 'N', 'E', 'z', 'j', 'L', 'B', 'p', 'i', 't', 'S', 'W'},
        {'2', 'G', 'W', '9', 'i', 'Q', 'e', '6', '1', '4', '_', 't', 'w', 's', 'F', 'd', '3', 'V', 'D', 'C', 'R', '0',
            'N', '7', 'S', 'j', 'a', 'y', 'l', 'f', 'I', 'v', '8', 'E', 'O', 'J', 'b', 'q', 'B', 'U', 'z', 'c', 'X',
            '5', 'o', 'K', 'p', 'g', 'u', 'L', 'T', 'Z', 'P', 'n', 'M', 'x', 'r', '-', 'h', 'Y', 'k', 'A', 'm', 'H'},
        {'y', '9', 'K', 'X', 'p', 'w', 'S', 'u', 's', '8', 'Q', 'n', 'h', 'g', 'N', '2', '3', 't', 'E', 'V', 'B', 'x',
            'U', 'o', '_', 'c', 'M', '6', 'a', 'C', 'f', '4', 'O', 'F', 'P', 'r', '1', 'H', 'z', '0', 'j', 'J', 'q',
            'm', 'D', 'Y', 'R', 'i', '5', 'Z', '-', 'L', '7', 'b', 'k', 'A', 'd', 'W', 'l', 'e', 'G', 'v', 'T', 'I'}};

    private static final byte[][] bytes = new byte[digits.length][128];
    private static final byte[] index = new byte[128];

    static {
        for (int x = 0; x < digits.length; x++) {
            char[] ds = digits[x];
            byte[] bs = bytes[x];
            index[ds[0]] = (byte) x;
            Arrays.fill(bs, (byte) -1);
            for (int i = 0; i < ds.length; i++)
                bs[ds[i]] = (byte) i;
        }
    }

    public static final char[] encode(byte[] in) {
        int offset;
        if (in.length > 1) {
            offset = Math.abs((in[0] * 31 + in[1] + in.length) % 64);
        } else {
            offset = Math.abs((in[0]) % 64);
        }

        int iLen = in.length;
        int oDataLen = (iLen * 4 + 2) / 3; // output length without padding
        char[] out = new char[oDataLen + 1];
        int ip = 0;
        int op = 0;

        int cursor = offset;
        while (ip < iLen) {
            char[] map1 = digits[cursor++];
            if (cursor == 64)
                cursor = 0;
            int i0 = in[ip++] & 0xff;
            int i1 = ip < iLen ? in[ip++] & 0xff : 0;
            int i2 = ip < iLen ? in[ip++] & 0xff : 0;
            int o0 = i0 >>> 2;
            int o1 = ((i0 & 3) << 4) | (i1 >>> 4);
            int o2 = ((i1 & 0xf) << 2) | (i2 >>> 6);
            int o3 = i2 & 0x3F;
            out[op++] = map1[o0];
            out[op++] = map1[o1];
            if (op < oDataLen) {
                out[op++] = map1[o2];
            }
            if (op < oDataLen) {
                out[op++] = map1[o3];
            }
        }
        out[oDataLen] = digits[offset][0];
        return out;
    }

    public static final byte[] decode(char[] in) throws UnsupportedEncodingException {
        int offset = index[in[in.length - 1]];
        int iLen = in.length - 1;

        int oLen = (iLen * 3) / 4;
        byte[] out = new byte[oLen];
        int ip = 0;
        int op = 0;

        int cursor = offset;
        while (ip < iLen) {
            char[] map1 = digits[cursor];
            byte[] map2 = bytes[cursor];
            cursor++;
            if (cursor == 64)
                cursor = 0;

            int i0 = in[ip++];
            int i1 = in[ip++];
            int i2 = ip < iLen ? in[ip++] : map1[0];
            int i3 = ip < iLen ? in[ip++] : map1[0];

            if (i0 > 127 || i1 > 127 || i2 > 127 || i3 > 127)
                throw new UnsupportedEncodingException("超出code64解码范围.");

            int b0 = map2[i0];
            int b1 = map2[i1];
            int b2 = map2[i2];
            int b3 = map2[i3];

            if (b0 < 0 || b1 < 0 || b2 < 0 || b3 < 0)
                throw new UnsupportedEncodingException("超出code64解码范围.");

            int o0 = (b0 << 2) | (b1 >>> 4);
            int o1 = ((b1 & 0xf) << 4) | (b2 >>> 2);
            int o2 = ((b2 & 3) << 6) | b3;
            out[op++] = (byte) o0;
            if (op < oLen)
                out[op++] = (byte) o1;
            if (op < oLen)
                out[op++] = (byte) o2;
        }
        return out;
    }
}
