import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		/* IMPLEMENT THIS METHOD! */
		//para crear un pila y rastrear las etiquetas de apertura.

		Stack<HtmlTag> stack = new Stack<>();

		//extrae etiquetas una por una de la cola para verificar cada formato de etiqueta.
		while (!tags.isEmpty()){
			HtmlTag tag = tags.poll();

			// si no es etiqueta de cerrada y no es de autocierre se agregará a la pila
			if (tag.isOpenTag()&& !tag.isSelfClosing()) {
				stack.push(tag);

				// omitir etiquetas de autocerrado, ya que no afectan en nada en la pila
			} else if (tag.isSelfClosing()) {
				continue;

				// si es etiqueta de cierre, que verifique si está vacía o si no coincide la etiqueta superior con la de cierre.
			} else if (stack.isEmpty()|| !stack.peek().matches(tag)) {
				//Si la pila está vacía o no coincide, devuelve la pila con las etiquetas no cerradas.

				return stack;
			} else {
				//Si coincide, elimina la etiqueta de apertura de la pila.
				stack.pop();
			}
		}
		//Retorna una pila vacía para indicar que el HTML es válido.
		return stack.isEmpty() ? new Stack<>() : stack;

	}
}

