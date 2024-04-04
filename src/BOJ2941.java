import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BOJ2941 {
    public static void main(String[] args) throws IOException {
        List<String> setup = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for (String pattern : setup) {
            str = str.replace(pattern, "a");
        }

        System.out.println(str.length());
    }
}
