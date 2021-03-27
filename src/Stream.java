import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*   Created by IntelliJ IDEA.
 *   Author: Dimpal Agrawal
 *   Date: 12/6/2020
 *   Time: 11:59 AM
 *   File: Stream.java
 */
public class Stream {
    public static void main(String[] args) {
        int num[] = {1,2,3,4,5,6};
        var stream= Arrays.stream(num);
        System.out.println(stream.filter(numbers -> numbers % 2 == 0).count());
    }
}