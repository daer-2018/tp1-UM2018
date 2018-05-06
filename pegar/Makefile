CC = gcc
OBJECTS = pegar.o gestionar_archivo.o
CFLAGS = -c $(DEBUG)

pegar: $(OBJECTS)
		$(CC) $(DEBUG) $(OBJECTS) -o pegar
		@echo "pegar, creado!"
pegar.o : pegar.c gestionar_archivo.c archivo_header.h parametro_header.h
		$(CC) $(CFLAGS) pegar.c
gestionar_archivo.o : gestionar_archivo.c archivo_header.h
		$(CC) $(CFLAGS) gestionar_archivo.c
test: pegar
	ls ../tools/part-0* | ./pegar -o archivo_salida.txt
ayuda: pegar
	./pegar -h
clean:
	$(RM) pegar *.o *~


