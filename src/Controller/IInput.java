package Controller;

public interface IInput {
    public int InputInteger();
    public double InputDouble();
    public long InputLong();
    public String InputString();
    void closeScanner();
}
