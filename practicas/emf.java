package practicas;

public class emf
{
    private static EntityManagerFactory emf;

    public static EntityManagerFactory getInstance ()
    {
        if (emf == NULL)
            emf = Persistance.createEntityManagerFactory("nombre");
        return = emf;
    }
}
