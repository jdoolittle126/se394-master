## Quest 5
In this quest, we make our own queue and use it to store image objects. I created the JPriorityQueue, which allows you to store items and elevate them up the queue based on priority. The JPriorityQueue uses a JPriorityWrapper, a class that encapsulates the item for queue with a priority, which can be of any type that implements Comparable. JPriorityQueues have the following functionality:

	jPriorityQueue.clear()
	jPriorityQueue.isEmpty()
	jPriorityQueue.peek()
	jPriorityQueue.enqueue(item)
	jPriorityQueue.enqueue(item, priority)
	jPriorityQueue.dequeue()
	jPriorityQueue.toString()