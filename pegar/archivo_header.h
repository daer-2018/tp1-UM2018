#ifndef ARCHIVO_HEADER_H
#define ARCHIVO_HEADER_H	

#define BUFF 200 

#define FLAG_O O_CREAT|O_APPEND|O_RDWR 
#define MODO_O S_IRWXU

//"Interfaz":"usoComun"
typedef struct archivo
{
	int fd;
	int leid;
	int esct;
	char cont[BUFF];
	char *nomb;
}archivo_t;

int pegar_leidos(char *nombre,int salida);

#endif
	