CC = gcc
OBJECTS = cortar.o gestionar_archivo.o
CFLAGS = -c $(DEBUG)

cortar: $(OBJECTS)
		$(CC) $(DEBUG) $(OBJECTS) -o cortar -lm
		@echo "cortar, creado!"

cortar.o : cortar.c gestionar_archivo.c parametro_header.h archivo_header.h
		$(CC) $(CFLAGS) cortar.c

gestionar_archivo.o : gestionar_archivo.c archivo_header.h
		$(CC) $(CFLAGS) gestionar_archivo.c

test-s: cortar
	./cortar -i ../tools/contenido.txt -s 200 -o part
test-n: cortar
	./cortar -i ../tools/contenido.txt -n 3 -o part
ayuda: cortar
	./cortar -h
clean:
	$(RM) pegar *.o *~ *.txt
