import org.junit.Test;
import static org.junit.Assert.*;
import com.example.Fibonacci;

public class TesteFibo {

    @Test
    public void Teste1() {
        Fibonacci f = new Fibonacci();
        assertEquals(1L, f.fibo(1));
    }
    @Test
    public void Teste2() {
        Fibonacci f = new Fibonacci();
        assertEquals(2L, f.fibo(3));
    }
    @Test
    public void Teste3() {
        Fibonacci f = new Fibonacci();
        assertEquals(34L, f.fibo(9));
    }
    @Test
    public void Teste4() {
        Fibonacci f = new Fibonacci();
        assertEquals(233L, f.fibo(13));
    }
    @Test
    public void Teste5() {
        Fibonacci f = new Fibonacci();
        assertEquals(514229L, f.fibo(29));
    }
}