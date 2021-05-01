/* *****************************************************************************
 *  Name: Kyle Ferrigan     
 *  NetID: kbferrigan   
 *
 *  Partner Name: Patrick Galati
 *  Partner NetID: pagalati
 *
 *  Hours to complete assignment (optional): 10 hours each
 *
 **************************************************************************** */

Programming Assignment 5: Burrows-Wheeler

/* *****************************************************************************
 *  Which sorting algorithm did you use in CircularSuffixArray.java?
 *  Why did you choose it?
 **************************************************************************** */
Chose to use Java libraries Arrays.sort class method. It is efficient, avoids the use of substrings (too much time), and gives us access to append, inserting, and comparisons.

/* *****************************************************************************
 *  How long does your implementation of the Burrows-Wheeler data compression
 *  algorithm (BurrowsWheeler + MoveToFront + Huffman) take to compress and
 *  expand mobydick.txt? What is the compression ratio (number of bytes in
 *  compressed message divided by the number of bytes in the message)?
 *  Compare the results to that for running Huffman alone and GNU 
 *  command-line utility Gzip.
 **************************************************************************** */

Algorithm       Compression time    Expansion time           Compression ratio
------------------------------------------------------------------------------
My program      1 seconds          600 seconds              0.34(406kb/1164kb)
Huffman alone    1 second           .5 sec                0.560 (667651 / 1191463)
gzip          0.1 second            2secs                   0.38(445kb/1164kb)

See the Checklist for Bash commands to compress/expand.



/* *****************************************************************************
 *  What is the running time of each of the following methods as a function
 *  of the input size n and the alphabet size R, both in practice
 *  (on typical English text inputs) and in theory (in the worst case)?
 *  Use big Theta notation to simplify your answer (e.g., n, n + R, n log n,
 *  n log^2n n, n^2, or R n).
 *
 *  Include the time for sorting circular suffixes in Burrows-Wheeler
 *  transform().
 **************************************************************************** */

                                      typical            worst
---------------------------------------------------------------------
CircularSuffixArray constructor       n log n            n^2 log n
BurrowsWheeler transform()            R + n log n        R + n^2 log n
BurrowsWheeler inverseTransform()     R + n log n        R + n log n
MoveToFront encode()                  n^2                n^2
MoveToFront decode()                  n^2                n^2
Huffman compress()                    n + R log R        n + R log R
Huffman expand()                      n                  n





/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
None that we are aware of


/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings and lectures, but do
 *  include any help from people (including
 *  classmates and friends) and attribute them by name.
 **************************************************************************** */


/* *****************************************************************************
 *  Describe any serious problems you encountered.                    
 **************************************************************************** */
Prior to adjustments, we had a StackOverFlow error when testing mobydick.txt when using recursion


/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it. Additionally, you may include any suggestions
 *  for what to change or what to keep (assignments or otherwise) in future 
 *  semesters.
 **************************************************************************** */


/* *****************************************************************************
 *  Include the screenshots of your output.
 **************************************************************************** */
