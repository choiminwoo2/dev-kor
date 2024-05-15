
export class CustomError extends Error {
    private status: string;
    constructor(message : string, status : string) {
        super(message);
        this.name = this.constructor.name;
        this.status = status;
        Error.captureStackTrace(this, this.constructor);
    }
}
