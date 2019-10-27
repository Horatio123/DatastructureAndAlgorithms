#include<stdio.h>
#include<limits.h>
#include<stdlib.h>
#include<stdbool.h>
struct Queue
{
	int front, rear, size, cap;
	int* arr;
};
struct Queue* createQueue(int cap) {
	struct Queue* queue = (struct Queue*) malloc(sizeof(struct Queue));
	queue->cap = cap;
	queue->front = queue->size = 0;
	queue->rear = queue->cap -1;
	queue->arr = (int*) malloc(queue->cap * sizeof(int));
	return queue;
}
bool isEmpty(struct Queue* queue) {
	return (queue->size == 0);
}
bool isFull(struct Queue* queue) {
	//printf("%d %d\n", queue->size, queue->cap);
	return (queue->size == queue->cap);
}

void enqueue(struct Queue* queue, int item) {
	if (isFull(queue))
	{
		printf("%s\n", "the queue is full");
		return;
	}
	queue->rear = (queue->rear + 1) % queue->cap;
	queue->arr[queue->rear] = item;
	queue->size += 1;
	printf("enqueue %d\n", item);
}
int dequeue(struct Queue* queue) {
	if (isEmpty(queue)) {
		printf("%s\n", "the queue is empty");
		return INT_MIN;
	}
	int output = queue->arr[queue->front];
	queue->front = (queue->front + 1) % queue->cap;
	queue->size -= 1;
	printf("dequeue %d\n", output);
	return output;
}

int front(struct Queue* queue) {
	if (isEmpty(queue)) {
		return INT_MIN;
	}
	return queue->arr[queue->front];
}
int rear(struct Queue* queue) {
	if (isEmpty(queue)) {
		return INT_MIN;
	}
	return queue->arr[queue->rear];
}

void display(struct Queue* queue) {
	printf("%s\n", "hhhh");
	//printf("%d\n", queue->size);
	printf("display queue: ");
	for (int i = 0; i < queue->size; i++)
	{
		printf("%d-->", queue->arr[(queue->front + i) % queue->cap]);
		//printf("%d-->", queue->size);
	}
		printf("\n");
}


int main(int argc, char const *argv[])
{
	struct Queue* qq = createQueue(2);
	int c = dequeue(qq);
	enqueue(qq, 2);
	enqueue(qq, 9);
	enqueue(qq, 5);
	printf("front is %d, rear is %d\n", front(qq), rear(qq));
	display(qq);
	int a = dequeue(qq);
	int b = dequeue(qq);
	printf("%d %d %d\n", a, b, c);

	return 0;
}