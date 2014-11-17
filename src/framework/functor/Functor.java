package framework.functor;

public interface Functor<T, R> {
	public abstract void compute(T element);

	public abstract R getValue();
}
