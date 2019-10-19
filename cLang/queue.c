#include<stdio.h>
#include<limits.h>
#include<stdlib.h>
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

void enqueue(struct Queue* queue, int item) {
	queue->rear = (queue->rear + 1) % queue->cap;
	queue->arr[queue->rear] = item;
	queue->size += 1;
}
int dequeue(struct Queue* queue) {
	int output = queue->arr[queue->front];
	queue->front = (queue->front + 1) % queue->cap;
	queue->size -= 1;
	return output;
}

int main(int argc, char const *argv[])
{
	struct Queue* qq = createQueue(5);
	enqueue(qq, 2);
	enqueue(qq, 9);
	int a = dequeue(qq);
	int b = dequeue(qq);
	printf("%d %d\n", a, b);

	return 0;
}