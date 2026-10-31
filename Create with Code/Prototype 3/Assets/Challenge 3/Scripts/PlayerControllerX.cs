using UnityEngine;
using UnityEngine.InputSystem;

public class PlayerControllerX : MonoBehaviour
{
    public bool gameOver;

    public float floatForce;
    private float gravityModifier = 1.5f;
    private Rigidbody playerRb;

    public InputAction floatAction;

    public ParticleSystem explosionParticle;
    public ParticleSystem fireworksParticle;

    private AudioSource playerAudio;
    public AudioClip moneySound;
    public AudioClip explodeSound;
    private bool isLowEnough;
    public AudioClip bounceSound;
    private bool hasBounced;


    // Start is called before the first frame update
    void Start()
    {
        Physics.gravity *= gravityModifier;
        playerAudio = GetComponent<AudioSource>();
        floatAction.Enable();
        playerRb = GetComponent<Rigidbody>();

        // Apply a small upward force at the start of the game
        playerRb.AddForce(Vector3.up * 5, ForceMode.Impulse);

    }

    // Update is called once per frame
    void Update()
    {
        isLowEnough = playerRb.position.y < 15f;

        // Float up only when below the height limit
        if (floatAction.IsPressed() && !gameOver && isLowEnough)
        {
            playerRb.AddForce(Vector3.up * floatForce);
        }
    }

    void FixedUpdate()
    {
        // Prevent the player from going above y = 15
        if (playerRb.position.y >= 15f)
        {
            Vector3 position = playerRb.position;
            position.y = 15f;
            playerRb.position = position;

            // Stop upward momentum
            if (playerRb.linearVelocity.y > 0f)
            {
                playerRb.linearVelocity = new Vector3(
                    playerRb.linearVelocity.x,
                    0f,
                    playerRb.linearVelocity.z
                );
            }
        }

        // Bounce off the ground when below y = 0
        if (playerRb.position.y <= 0f && !hasBounced)
        {
            Vector3 position = playerRb.position;
            position.y = 0f;
            playerRb.position = position;

            // Bounce upward
            playerRb.linearVelocity = new Vector3(
                playerRb.linearVelocity.x,
                0f,
                playerRb.linearVelocity.z
            );

            playerRb.AddForce(Vector3.up * 10f, ForceMode.Impulse);

            // Play bounce sound
            playerAudio.PlayOneShot(bounceSound, 1.0f);

            hasBounced = true;
        }

        if (playerRb.position.y > 0.1f)
        {
            hasBounced = false;
        }
    }

    private void OnCollisionEnter(Collision other)
    {
        Debug.Log("Collided with: " + other.gameObject.name
            + " | Tag: " + other.gameObject.tag);

        if (other.gameObject.CompareTag("Bomb"))
        {
            explosionParticle.Play();
            playerAudio.PlayOneShot(explodeSound, 1.0f);
            gameOver = true;
            Debug.Log("Game Over!");
            Destroy(other.gameObject);
        }
        else if (other.gameObject.CompareTag("Money"))
        {
            fireworksParticle.Play();
            playerAudio.PlayOneShot(moneySound, 1.0f);
            Destroy(other.gameObject);
        }
    }

}
