/* ArrayDeques come with a lot of convenient functions to work with these double ended queues, e.g.:
- .add(), .addFirst(), .addLast()
- .first(), .last()
- .isEmpty()
- .remove(), .removeFirst(), .removeLast()
- .clear()
- .size
*/
import kotlin.collections.ArrayDeque

class EmptyBufferException: Exception("Buffer is empty")

class BufferFullException: Exception("Buffer is full")

class CircularBuffer<T>(private val capacity: Int) {

    // make sure the provided capacity is a positive number
    init {
        require(capacity > 0) { "Capacity must be positive" }
    }

    // create an empty buffer of type ArrayDeque (deque = double ended queue)
    private val buffer = ArrayDeque<T>()

    // throw an exception if the buffer is empty
    // buffer.removeFirst() removes and returns the first element in the buffer
    fun read() : T {
        if (buffer.isEmpty()) throw EmptyBufferException()
        return buffer.removeFirst()
    }

    // throw an exception if the buffer is full
    // write the value to the end of the buffer
    fun write(value: T) {
        if (buffer.size == capacity) throw BufferFullException()
        buffer.addLast(value)
    }

    // write the value to the end of the buffer
    // if the buffer is full, first remove the first item
    fun overwrite(value: T) {
        if (buffer.size == capacity) buffer.removeFirst()
        buffer.addLast(value)
    }

    // clear all elements in the buffer
    fun clear() {
        buffer.clear()
    }
}