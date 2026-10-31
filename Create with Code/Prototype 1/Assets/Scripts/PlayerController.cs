using UnityEngine;
using UnityEngine.InputSystem;

public class PlayerController : MonoBehaviour
{
    // Movement tuning (editable in Inspector)
    public float speed = 5.0f;
    public float turnSpeed = 5f;
    // Input System action exposed in Inspector for binding (WASD/Arrow keys)
    public InputAction moveAction;

    // Current input value (x = left/right, y = forward/back), kept private for internal use
    public Vector2 moveInput;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        // Enable the MoveAction so it starts reading input
        moveAction.Enable();
    }

    // Update is called once per frame
    void Update()
    {
        // Read the 2D vector from MoveAction (x: horizontal, y: vertical)
        moveInput = moveAction.ReadValue<Vector2>();

        // Move the vehicle forward/back along local Z using y component
        transform.Translate(Vector3.forward * Time.deltaTime * speed * moveInput.y);

        // Rotate around local Y (yaw) using the x component
        transform.Rotate(Vector3.up, Time.deltaTime * turnSpeed * moveInput.x);
    }
}