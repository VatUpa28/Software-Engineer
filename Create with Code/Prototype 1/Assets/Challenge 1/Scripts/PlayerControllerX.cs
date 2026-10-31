using UnityEngine;
using UnityEngine.InputSystem;

public class PlayerControllerX : MonoBehaviour
{
    public float speed;
    public float rotationSpeed;
    public InputAction moveAction;

    public Vector2 moveInput;

    // Start is called before the first frame update
    void Start()
    {
        moveAction.Enable();
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        moveInput = moveAction.ReadValue<Vector2>();

        // Move forward automatically
        transform.Translate(Vector3.forward * speed * Time.fixedDeltaTime);

        // Rotate up/down
        Debug.Log(moveInput);
        transform.Rotate(Vector3.right * rotationSpeed * 20 * -1*moveInput.y * Time.fixedDeltaTime);
    }
}
